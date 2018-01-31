package jaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Bean> dataList = new ArrayList<>();
		dataList.add(new Bean("1", "User1 ", "City 1"));
		dataList.add(new Bean("2", "User2 ", "City 2"));
		dataList.add(new Bean("3", "User3 ", "City 3"));
		dataList.add(new Bean("4", "User4 ", "City 4"));
		dataList.add(new Bean("5", "User5 ", "City 5"));
		dataList.add(new Bean("6", "User6 ", "City 6"));
		dataList.add(new Bean("7", "User7 ", "City 7"));
		
		
		try {
			File file = new  File("D://test.xml");
			if(!file.exists()) {
				file.createNewFile();
			}
			JAXBContext context = JAXBContext.newInstance(Result.class);
			
			Marshaller marshel = context.createMarshaller();
			marshel.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Result res = new Result();
			res.setBeanList(dataList);
			marshel.marshal(res, file);
			
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			
			Result obj = (Result) jaxbUnmarshaller.unmarshal(file);
			List<Bean> beanListObj = obj.getBeanList();
			
			for(Bean bean: beanListObj) {
				System.out.println(bean.getId() +" "+bean.getName() + "" + bean.getCity());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
