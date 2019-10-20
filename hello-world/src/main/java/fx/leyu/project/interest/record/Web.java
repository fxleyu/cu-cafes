package fx.leyu.project.interest.record;

import fx.leyu.project.interest.bean.Record;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Web {

	public Record getData(String path) {
		Record r = new Record();
		try {
			URL url = new URL(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String content = br.readLine();
			br.close();
			int idStart = content.indexOf("<td>", content.indexOf("证件类型"))+4;
			int idEnd = content.indexOf("</td>", idStart);
			String id = content.substring(idStart, idEnd);
			if ("ID".equals(id)) {
				r.setId(getValue(content, "证件编号"));
				r.setName(getValue(content, "姓名"));
				r.setEmail(getValue(content, "电子邮件"));
				r.setLocation(getValue(content, "地址"));
				r.setTime(getValue(content, "登记时间"));
				r.setSite(getValue(content, "地区1") 
						+ getValue(content, "地区2")
						+ getValue(content, "地区3")
						+ getValue(content, "地区4")
						+ getValue(content, "地区5")
				);
				r.setGender(getValue(content, "性别"));
				r.setAge(getValue(content, "年龄"));
				r.setBirthday(getValue(content, "生日"));
				r.setPhone(getValue(content, "手机"));
			}
		} catch (Exception e) {
			System.out.println("获取记录异常！！");
		}
		return r;
	}

	private String getValue(String content, String flag) {
		int start = content.indexOf("<td>", content.indexOf(flag)) + 4;
		int end = content.indexOf("</td>", start);
		String result = content.substring(start, end);
		if ("&nbsp;".equals(result)) {
			result = "";
		}
		return result;
	}

}
