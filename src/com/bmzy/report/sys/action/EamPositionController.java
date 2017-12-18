package com.bmzy.report.sys.action;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.generic.core.support.PageGridView;
import com.bmzy.report.model.EamPosLineEntity;
import com.bmzy.report.model.EamPositonEntity;
import com.bmzy.report.service.IEamPosLineService;
import com.bmzy.report.service.IEamPositionService;
import com.bmzy.report.service.ISysUserService;
import com.bmzy.report.util.Page;

import tk.mybatis.mapper.entity.Example;

/**
 * 车站管理控制层
 * 
 * @author 86101
 *
 */
@Controller
@RequestMapping("/sys/eamPosition")
public class EamPositionController extends ActionBaseController<PageBaseParameter> {

	@Resource
	private IEamPositionService eamPositionCore;
	@Resource
	private IEamPosLineService eamPosLineCore;
	// 获得user的service
	@Resource
	private ISysUserService sysUser;
	/*
	 * @Resource private IEnverService<EamPositonEntity> enverService;
	 */

	@RequestMapping(value = "/logsDate", method = { RequestMethod.POST, RequestMethod.GET })
	public void getLogsByClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * String logid = request.getParameter("logid");
		 * PageModel<EamPositonEntity> page =
		 * enverService.findEntityListPage(EamPositonEntity.class, logid,
		 * request); PageGridView<SupperEnver<EamPositonEntity>> eamPositionView
		 * = new PageGridView<SupperEnver<EamPositonEntity>>();
		 * 
		 * List<SupperEnver<EamPositonEntity>> entityList =
		 * page.getEntityList(); for (SupperEnver<EamPositonEntity> supperEnver
		 * : entityList) {
		 * supperEnver.setUserId(sysSuper.getEntity(supperEnver.getUserId()).
		 * getUserName()); EamPositonEntity eamPosition =
		 * eamPositionCore.queryByID(supperEnver.getEntity().getId());
		 * supperEnver.getEntity().setPosLine(eamPosition.getPosLine()); }
		 * 
		 * eamPositionView.setMaxResults(page.getPageRecorders());
		 * eamPositionView.setRows(entityList);
		 * eamPositionView.setRecords(page.getTotalRows()); writeJSON(response,
		 * eamPositionView);
		 */
	}

	@RequestMapping(value = "/logspage", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView matWatchUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String logid = request.getParameter("id");
		ModelAndView mav = new ModelAndView("/sys/pagelogs/sysPositionlogs");
		mav.addObject("logid", logid);
		return mav;
	}

	@RequestMapping(value = "/getLineNames", method = { RequestMethod.POST, RequestMethod.GET })
	public void getLineNames(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Example example = new Example(EamPosLineEntity.class);
		example.createCriteria().andIsNotNull("line_code");
		List<EamPosLineEntity> lineList = eamPosLineCore.selectByExample(example);
		String json = getLineNameJson(lineList).toString();
		writeJSON(response, json);
	}

	/**
	 * 获取父位置左侧树 含有名称
	 * 是线路的名字 即需要线路最为根节点友需要车站最为子节点
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSysPositionMTree1", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysPositionMTree1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获得一个字符串
		StringBuilder sysPositionMtree = new StringBuilder();
		sysPositionMtree.append("[");
		// 将根节点添加进去（线路）
		sysPositionMtree.append(
				"{ id:\"" + "null" + "\", pId:\"" + "null" + "\", name:\"" + "线路" + "\", open:\"" + "true" + "\"},");
		Example example = new Example(EamPosLineEntity.class);
		example.createCriteria().andIsNotNull("line_code");
		List<EamPosLineEntity> lineList = eamPosLineCore.selectByExample(example);
		for (int i = 0; i < lineList.size(); i++) {
			String FID = new String();
			// 获得线路的编码
			if (lineList.get(i).getLine_code() != null) {
				FID = "null";
			} else {
				FID = "null";
			}
			// 标记状态
			boolean statu = false;
			// 合成码 ？？？ 这个用来干什么？？？
			String compoundCodes = null;
			try {
				compoundCodes = request.getSession().getAttribute("compoundCode").toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (compoundCodes != null) {
				// 把合成码用'-'分开
				String[] codeS = compoundCodes.split("-");
				for (int j = 1; j < codeS.length; j++) {
					if (codeS[j].equals(lineList.get(i).getLine_code())) {
						statu = true;
					}
				}
			}
			sysPositionMtree.append("{ id:\"" + lineList.get(i).getLine_code() + "\", pId:\"" + FID + "\", name:\""
					+ lineList.get(i).getLine_name() + " (" + lineList.get(i).getLine_code() + ")\", open:\"" + statu
					+ "\", isParent:\"" + "true" + "\"},");
		}
		request.getSession().removeAttribute("compoundCode");
		// 去掉最后一个逗号，然后用中括号来替代
		sysPositionMtree.delete(sysPositionMtree.length() - 1, sysPositionMtree.length()).append("]");
		writeJSON(response, sysPositionMtree.toString());
	}
	
	/**
	 * 
	 * 获得节点下面的数据
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getChildNodes", method = { RequestMethod.POST, RequestMethod.GET })
	public void getChildNodes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String line_code = request.getParameter("id");
		
		StringBuilder sysPositionMtree = new StringBuilder();
		sysPositionMtree.append("[");
		Example example = new Example(EamPositonEntity.class);
		example.createCriteria().andEqualTo("line_code", line_code);
		List<EamPositonEntity> positionList = eamPositionCore.selectByExample(example);
		for (int i = 0; i < positionList.size(); i++) {
			sysPositionMtree.append("{ id:\"" + positionList.get(i).getPosition_no() + "\", pId:\"" + line_code
					+ "\", name:\"" + positionList.get(i).getPosition_name() + " ("
					+ positionList.get(i).getPosition_code() + ")\"},");
		}
		request.getSession().removeAttribute("compoundCode");
		sysPositionMtree.delete(sysPositionMtree.length() - 1, sysPositionMtree.length()).append("]");
		System.out.println("send  "+sysPositionMtree.toString());
		writeJSON(response, sysPositionMtree.toString());
	}
	
	/**
	 * 按照线路的条件来进行搜索
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPositionForLine", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysPositionMs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fid = request.getParameter("line_code");
		Page page = new Page(EamPositonEntity.class);
		Example example = page.MakeSearch(request);

		if (fid != null && !fid.equals("") && !fid.equals("all")) {
			page.getAnd().andEqualTo("line_code", fid);
		} else {
		}
		List<EamPositonEntity> queryResult = eamPositionCore.selectByExample(example);
		PageGridView<EamPositonEntity> positionListView = new PageGridView<EamPositonEntity>();
		positionListView.setMaxResults(Page.getMaxResults());
		positionListView.setRecords(Page.getRecords());
		positionListView.setRows(queryResult);
		writeJSON(response, positionListView);
	}

	@RequestMapping(value = "/getEamPosition", method = { RequestMethod.POST, RequestMethod.GET })
	public void getCourses(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Page page = new Page(EamPositonEntity.class);
		Example example = page.MakeSearch(request);

		List<EamPositonEntity> queryResult = eamPositionCore.selectByExample(example);

		PageGridView<EamPositonEntity> positionListView = new PageGridView<EamPositonEntity>();

		positionListView.setMaxResults(Page.getMaxResults());
		positionListView.setRecords(Page.getRecords());
		positionListView.setRows(queryResult);

		writeJSON(response, positionListView);

	}

	/**
	 * 操作的选择（增删改查）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/doOperate", method = { RequestMethod.POST, RequestMethod.GET })
	public void doOperate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("position_no");
		System.out.println("oper" + oper + "----------------" + "id" + id);
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			System.out.println("==========del==ids======" + id);
			for (String delid : ids) {
				eamPositionCore.delete(delid);
			}
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition", "attachment;filename=file.xls");
				OutputStream out = response.getOutputStream();
				out.write(request.getParameter("csvBuffer").getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String position_code = request.getParameter("position_code");
			String f_position_no = request.getParameter("f_position_no");
			String position_name = request.getParameter("position_name");
			String line_code = request.getParameter("line_code");

			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			String dept_no = request.getParameter("dept_no");
			String belong_dept = request.getParameter("belong_dept");
			String memo = request.getParameter("memo");

			EamPosLineEntity posLine = eamPosLineCore.selectByKey(line_code);

			String position_no = posLine.getLine_code() + position_code;

			EamPositonEntity entity = new EamPositonEntity();
			if (oper.equals("edit")) {
				entity = eamPositionCore.selectByKey(id);
			}

			entity.setBelong_dept(belong_dept);
			entity.setDept_no(dept_no);
			entity.setF_position_no(f_position_no);
			entity.setLine_code(line_code);
			entity.setMemo(memo);
			entity.setPosition_name(position_name);
			entity.setPosition_no(position_no);
			entity.setPosition_code(position_code);

			entity.setLongitude(Float.parseFloat(longitude));
			entity.setLatitude(Float.parseFloat(latitude));

			System.out.println(entity.getLongitude() +"++++++"+entity.getLatitude());

			if (oper.equals("edit")) {
				eamPositionCore.updateAll(entity);
			} else if (oper.equals("add")) {
				eamPositionCore.save(entity);
			}
		}

	}

	@Override
	@RequestMapping(value = "/getColHidden", method = { RequestMethod.POST, RequestMethod.GET })
	public void getColHidden(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<String> cols = new ArrayList<String>();
		writeGridHead(response, cols);
	}

	public Date changeStringtoDate(String date) {
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		Date resultDate = null;
		try {
			resultDate = (Date) format.parseObject(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDate;
	}

	public String contrastObj(Object pojo1, Object pojo2) {
		String str = "";

		try {
			Class<? extends Object> clazz = pojo1.getClass();
			Field[] fields = clazz.getDeclaredFields();
			int i = 1;
			for (Field field : fields) {
				if ("serialVersionUID".equals(field.getName())) {
					continue;
				}
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				Method getMethod = pd.getReadMethod();
				Object o1 = getMethod.invoke(pojo1);
				Object o2 = getMethod.invoke(pojo2);
				if (o1 == null || o2 == null) {
					continue;
				}
				if (!o1.toString().equals(o2.toString())) {
					if (i != 1) {
						str += "-";
					}
					str += str + o2;
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	public StringBuffer getLineNameJson(List<EamPosLineEntity> lineList) {
		StringBuffer resultJson = new StringBuffer();
		resultJson.append("<select>");
		for (EamPosLineEntity entity : lineList) {
			resultJson.append("<option value='" + entity.getLine_code() + "'>" + entity.getLine_name() + "</option>");
		}
		resultJson.append("</select>");
		System.out.println("resultJson" + resultJson);
		return resultJson;
	}

}
