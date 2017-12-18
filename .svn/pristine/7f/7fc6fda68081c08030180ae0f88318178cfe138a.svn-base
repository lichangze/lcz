package com.bmzy.report.timer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import com.bmzy.report.home.HomeController;
import com.bmzy.report.model.WeatherEntity;
import com.bmzy.report.service.IWeatherService;
import com.bmzy.report.viewModel.WeatherViewModel;

import tk.mybatis.mapper.entity.Example;
@Service
public class Weather {
	@Resource
	private IWeatherService weatherService;
	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
	public final static SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");// 小写的mm表示的是分钟
	public void addWerther(){
		 String s=Weather.sendGet("http://weather.51wnl.com/weatherinfo/GetMoreWeather?cityCode=101010100&weatherType=1", "key=123&v=456");
		 ObjectMapper mapper = new ObjectMapper();
			WeatherViewModel entity;
			WeatherEntity we = null;
			try {
				entity = mapper.readValue(s, WeatherViewModel.class);
				we = new WeatherEntity();
				we.setCity(entity.getWeatherinfo().getCity());
				we.setRadar(entity.getWeatherinfo().getRadar());
				we.setSd(entity.getWeatherinfo().getSD());
				we.setTemp(entity.getWeatherinfo().getTemp());
				we.setWd(entity.getWeatherinfo().getWD());
				we.setWs(entity.getWeatherinfo().getWS());
				we.setWse(entity.getWeatherinfo().getWSE());
				we.setTime(entity.getWeatherinfo().getTime());
				try {
					we.setDate(HomeController.sdf.parse(entity.getWeatherinfo().getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					weatherService.save(we);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	/*private WeatherEntity selectDateWe(){
		WeatherEntity we = null;
		Example example = new Example(WeatherEntity.class);
		example.createCriteria().andEqualTo("date", sdf.format(new Date()));
		List<WeatherEntity> list = weatherService.selectByExample(example);
		if(list.size() == 0){
			we = new WeatherEntity();
		}else{
			we = list.get(0);
		}
		return we;
	}
	
	*/
	public static String sendGet(String url, String param) {
       String result = "";
       BufferedReader in = null;
       try {
           String urlNameString = url + "?" + param;
           URL realUrl = new URL(urlNameString);
           // 打开和URL之间的连接
           URLConnection connection = realUrl.openConnection();
           // 设置通用的请求属性
           connection.setRequestProperty("accept", "*/*");
           connection.setRequestProperty("connection", "Keep-Alive");
           connection.setRequestProperty("Accept-Charset", "UTF-8");
           connection.setRequestProperty("user-agent",
                   "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
           // 建立实际的连接
           connection.connect();
           // 获取所有响应头字段
           // 遍历所有的响应头字段
           // 定义 BufferedReader输入流来读取URL的响应
           in = new BufferedReader(new InputStreamReader(
                   connection.getInputStream(),"utf-8"));
           String line;
           while ((line = in.readLine()) != null) {
               result += line;
           }
       } catch (Exception e) {
           System.out.println("发送GET请求出现异常！" + e);
           e.printStackTrace();
       }
       // 使用finally块来关闭输入流
       finally {
           try {
               if (in != null) {
                   in.close();
               }
           } catch (Exception e2) {
               e2.printStackTrace();
           }
       }
       return result;
   }
	
}
