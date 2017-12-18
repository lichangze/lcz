package com.bmzy.report.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 组合查询
 * 
 * @author July_whj
 *
 */
public class Page {

	private static Class<?> entityClass = null;
	
	private static int maxResults = 0;
	private static Criteria c;
	private static Example e;
	private static com.github.pagehelper.Page<Object> page;
	/**
	 * 分页，过滤，排序<br/>
	 * { 'eq'='等于' },{ 'ne'='不等'},{ 'lt'='小于'}<br/>
	 * { 'le'='小于等于'},{ 'gt'='大于'},{ 'ge'='大于等于'}<br/>
	 * { 'in'='属于'},{ 'ni'='不属于'},{ 'cn'='包含'}
	 * 
	 * @param maxResults
	 * @param firstResult
	 * @param filters
	 *            为json数据格式
	 * @param sortedValue
	 *            排序规则desc asc
	 * @param sortedObject
	 *            排序列
	 * @return
	 * @return
	 */
	public Page(Class<?> entityClass) {
		Page.entityClass = entityClass;
	}

	
	public Criteria or(){
		c = e.or();
		return c;
	}
	
	public static long getRecords(){
		return page.getTotal();
	}
	/**
	 * 传入request对象，参数在这里活动
	 * 
	 * Integer firstResult = Integer.valueOf(request.getParameter("page"));<br>
	 * Integer maxResults = Integer.valueOf(request.getParameter("rows"));<br>
	 * String sortedObject = request.getParameter("sidx");<br>
	 * String sortedValue = request.getParameter("sord");<br>
	 * String filters = request.getParameter("filters");<br>
	 *
	 * _search:true nd:1502875037956 rows:30 page:1 sidx:menuOrder sord:asc
	 * filters:{"groupOp":"AND","rules":[{"field":"menuNo","op":"cn","data":"12"}]}
	 * searchField: searchString: searchOper:
	 * 
	 * @param request
	 * @return
	 */
	public Example MakeSearch(HttpServletRequest request) {
		Integer firstResult = Integer.valueOf(request.getParameter("page"));
		Integer maxResults = Integer.valueOf(request.getParameter("rows"));
		String sortedObject = request.getParameter("sidx");
		String sortedValue = request.getParameter("sord");
		String filters = request.getParameter("filters");
		Page.e = new Example(entityClass);
		Page.c  = e.createCriteria();
	    page = PageHelper.startPage(firstResult, maxResults,true);
		Page.maxResults = maxResults;
		if (sortedObject != null && !sortedObject.equals("")) {
			if (sortedValue.equals("asc")) {
				e.setOrderByClause(sortedObject);
			}else if(sortedValue.equals("desc")){
				e.setOrderByClause(sortedObject +" desc");
			}
		}
		if (StringUtils.isNotBlank(filters)) {
			ObjectMapper mapper = new ObjectMapper();
			PageModel entity;
			try {
				entity = mapper.readValue(filters, PageModel.class);
				for (int i = 0; i < entity.getRules().size(); i++) {
					Rules rules = entity.getRules().get(i);
					String op = rules.getOp();
					String filed = rules.getField();
					String data = rules.getData();
					// { oper:'eq', text:'等于'},
					if (op.equals("eq")){
						c.andEqualTo(filed, data);
					}
					// { oper:'ne', text:'不等'},
					if (op.equals("ne")){
						c.andNotEqualTo(filed, data);
					}
					// { oper:'lt', text:'小于'},
					if (op.equals("lt")){
						c.andLessThan(filed, data);
					}
					// { oper:'le', text:'小于等于'},
					if (op.equals("le")){
						c.andLessThanOrEqualTo(filed, data);
					}
					// { oper:'gt', text:'大于'},
					if (op.equals("gt")){
						c.andGreaterThan(filed, data);
					}
					// { oper:'ge', text:'大于等于'},
					if (op.equals("ge")){
						c.andGreaterThanOrEqualTo(filed, data);
					}
					// { oper:'in', text:'属于'},
					if (op.equals("in")){
						
					}
						// s.createCriteria().andIn(filed, data);
					// { oper:'ni', text:'不属于'},
					if (op.equals("ni")){
						
					}
					// { oper:'cn', text:'包含'},
					if (op.equals("cn")){
						c.andLike(filed, "%" + data + "%");
					}
					if (entity.getGroupOp().equalsIgnoreCase("OR")) {
						// s.addFilterOr(f);
					} else {
						// s.addFilterAnd(f);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return e;

	}

	
	
	
	public static Class<?> getEntityClass() {
		return entityClass;
	}

	

	public static int getMaxResults() {
		return maxResults;
	}

	


	

	public Criteria getAnd() {
		return c;
	}

	

	public Example getE() {
		return e;
	}

	

	public static void main(String[] args) {
		String str = "{\"groupOp\":\"AND\",\"rules\":[{\"field\":\"menuNo\",\"op\":\"cn\",\"data\":\"sys\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		PageModel entity;
		try {
			entity = mapper.readValue(str, PageModel.class);
			System.out.println(entity.getRules().get(0).getField());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class PageModel {
	private String groupOp;
	private List<Rules> rules;

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}

	public List<Rules> getRules() {
		return rules;
	}

	public void setRules(List<Rules> rules) {
		this.rules = rules;
	}

}

class Rules {
	private String field;
	private String op;
	private String data;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
