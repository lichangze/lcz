package com.bmzy.report.sys.action;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * 线路的控制层
 * 
 * @author 86101
 *
 */
@Controller
@RequestMapping("/sys/eamPosLine")
public class EamPosLineController extends ActionBaseController<PageBaseParameter> {
	@Resource
	private IEamPositionService eamPositionCore;
	@Resource
	private IEamPosLineService eamPosLineCore;
	/*
	 * @Resource private IEnverService<EamPosLineEntity> enverService;
	 */
	@Resource
	protected ISysUserService sysSuper;

	@RequestMapping(value = "/logsDate", method = { RequestMethod.POST, RequestMethod.GET })
	public void getLogsByClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  String logid = request.getParameter("logid");
		  EamPosLineEntity entity = eamPosLineCore.selectByKey(logid);
		  Page page = new Page(EamPosLineEntity.class);
		  Example example = page.MakeSearch(request);
		  List<EamPosLineEntity> queryResult = eamPosLineCore.selectByExampleLog(example);
		  queryResult.add(entity);
			PageGridView<EamPosLineEntity> positionListView = new PageGridView<EamPosLineEntity>();
			positionListView.setMaxResults(Page.getMaxResults());
			positionListView.setRecords(Page.getRecords());
			positionListView.setRows(queryResult);
		  writeJSON(response,positionListView);
		 
	}

	@RequestMapping(value = "/logspage", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView matWatchUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String logid = request.getParameter("id");
		ModelAndView mav = new ModelAndView("/sys/pagelogs/sysPosLinelogs");
		mav.addObject("logid", logid);
		return mav;
	}



	@RequestMapping(value = "/getEamPosLine", method = { RequestMethod.POST, RequestMethod.GET })
	public void getCourses(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Page page = new Page(EamPosLineEntity.class);
		Example example = page.MakeSearch(request);
		List<EamPosLineEntity> queryResult = eamPosLineCore.selectByExample(example);
		PageGridView<EamPosLineEntity> positionListView = new PageGridView<EamPosLineEntity>();
		positionListView.setMaxResults(Page.getMaxResults());
		positionListView.setRecords(Page.getRecords());
		positionListView.setRows(queryResult);
		writeJSON(response, positionListView);

	}

	/*
	 * @RequestMapping("/eamPosLine") public String toCourse(HttpServletRequest
	 * request,HttpServletResponse response){ return "page/sys/eamPosLine"; }
	 */

	@RequestMapping(value = "/doOperate", method = { RequestMethod.POST, RequestMethod.GET })
	public void doOperate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		System.out.println("oper" + oper + "----------------" + "id" + id);
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			System.out.println("==========del==ids======" + id);
			for (String delid : ids) {
				// 添加一个是否可以删除的判断
				if (isDelete(delid)) {
					eamPosLineCore.delete(delid);
				} else {
					writeJSON(response, "不能删除");
				}
			}
		} else {
			String line_code = request.getParameter("line_code");
			String line_name = request.getParameter("line_name");
			String line_m = request.getParameter("line_m");
			String dict_no = request.getParameter("dict_no");
			String line_type = request.getParameter("line_type");
			String line_strart_date = request.getParameter("line_strart_date");
			String memo = request.getParameter("memo");
			EamPosLineEntity entity = null;
			if (oper.equals("edit")) {
				entity = eamPosLineCore.selectByKey(id);
				entity.setLine_code(line_code);
				entity.setLine_name(line_name);
				entity.setLine_m(Double.parseDouble(line_m));
				entity.setDict_no(dict_no);
				entity.setLine_type(line_type);
				entity.setInvalid(true);
				entity.setLine_strart_date(changeStringtoDate(line_strart_date));
				entity.setMemo(memo);
				eamPosLineCore.updateAll(entity);
				eamPosLineCore.saveLog(entity);
			} else if (oper.equals("add")) {
				entity = new EamPosLineEntity();
				entity.setLine_code(line_code);
				entity.setLine_name(line_name);
				entity.setLine_m(Double.parseDouble(line_m));
				entity.setDict_no(dict_no);
				entity.setLine_type(line_type);
				entity.setLine_strart_date(changeStringtoDate(line_strart_date));
				entity.setMemo(memo);
				eamPosLineCore.save(entity);
				System.out.println("================"+entity.getId());
				eamPosLineCore.saveLog(entity);
			}
		}
	}

	public Date changeStringtoDate(String date) {
		/*
		 * System.out.println("date  "+date);
		 * 
		 * Timestamp ts = new Timestamp(System.currentTimeMillis()); String
		 * tsStr = date"2011-05-09 11:49:45"; try { ts =
		 * Timestamp.valueOf(tsStr); System.out.println(ts); } catch (Exception
		 * e) { e.printStackTrace(); }
		 */
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

	@Override
	public void getColHidden(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {

	}

	public boolean isDelete(String id) {
		boolean sure = true;
		List<EamPositonEntity> position = eamPositionCore.selectByExample(null);
		for (EamPositonEntity eamPositonEntity : position) {
			String line_id = eamPositonEntity.getPosLine();
			if (id.equals(line_id)) {
				sure = false;
				break;
			}
		}
		return sure;
	}

}
