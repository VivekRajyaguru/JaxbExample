package jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType (XmlAccessType.FIELD)
public class Result {

	@XmlElement(name = "bean")
	public List<Bean> beanList;
	
	public List<Bean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Bean> beanList) {
		this.beanList = beanList;
	}
	
	
	
}
