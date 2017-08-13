package fx.leyu.project.interest.record;

import fx.leyu.project.interest.DB.DB;
import fx.leyu.project.interest.bean.Record;

public class Main {

	public static void main(String[] args) {
		Web web = new Web();
		DB db = new DB("id", "record");
		String path = "http://www.kaifang007.com/p";
		for(int i = 5003452; i < 20050146; i++){
			System.out.println("正在处理第"+i+"条记录...............");
			Record r = web.getData(path+i);
			if(!r.isEmpty()){
				System.out.println(r.getName());
				db.insert(r);
			}
			
		}
		db.close();
	}

}
