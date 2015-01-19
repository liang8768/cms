package com.liang;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;

public class Test1 {
	public static void main(String[] args) throws IOException, TemplateException, URISyntaxException {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(Test1.class, "/com/liang");
		cfg.setObjectWrapper(new BeansWrapper());
		cfg.setSharedVariable("liang", "我是亮亮！");
		
		Map<String,Object> root = new HashMap<String, Object>();
		root.put("user", "Liang Liang");
		Map<String,Object> latest = new HashMap<String, Object>();
		root.put("latestProduct", latest);
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		
		
		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		TemplateHashModel staticModels = wrapper.getStaticModels();
		TemplateHashModel test2 = (TemplateHashModel) staticModels.get("com.liang.Test2");
		root.put("static", staticModels);
		root.put("Test2", test2);
		Template template = cfg.getTemplate("test.ftl");
		
		Writer out = new OutputStreamWriter(System.out);
		
		template.process(root, out);
		out.flush();
	}
}
