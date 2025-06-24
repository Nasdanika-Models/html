package org.nasdanika.models.html.gen;

import java.io.InputStream;

import org.nasdanika.common.SupplierFactory;
import org.nasdanika.common.Util;
import org.nasdanika.emf.FunctionAdapterFactory;
import org.nasdanika.exec.gen.ExecutionParticpantAdapterFactory;
import org.nasdanika.html.HTMLPage;
import org.nasdanika.models.html.HtmlPackage;
import org.nasdanika.models.html.Page;
import org.nasdanika.models.html.Script;
import org.nasdanika.ncore.NcorePackage;

public class HtmlAdapterFactory extends ExecutionParticpantAdapterFactory {
	
	public HtmlAdapterFactory() {
		ClassLoader classLoader = getClassLoader();
		
		registerAdapterFactory(
				new FunctionAdapterFactory<SupplierFactory<org.nasdanika.html.Tag>, org.nasdanika.models.html.Tag>(
					HtmlPackage.Literals.TAG, 
					Util.getSupplierFactoryClass(org.nasdanika.html.Tag.class), 
					classLoader, 
					e -> new TagSupplierFactoryAdapter<org.nasdanika.models.html.Tag>(e, this)));		
		
		registerAdapterFactory(
				new FunctionAdapterFactory<SupplierFactory<HTMLPage>, Page>(
					HtmlPackage.Literals.PAGE, 
					Util.getSupplierFactoryClass(HTMLPage.class), 
					classLoader, 
					PageSupplierFactoryAdapter::new));		
		
		registerAdapterFactory(
				new FunctionAdapterFactory<SupplierFactory<org.nasdanika.html.Tag>, Script>(
					HtmlPackage.Literals.SCRIPT, 
					Util.getSupplierFactoryClass(org.nasdanika.html.Tag.class), 
					classLoader, 
					ScriptSupplierFactoryAdapter::new));
		
		registerAdapterFactory(
				new FunctionAdapterFactory<SupplierFactory<InputStream>, org.nasdanika.ncore.List>(
					NcorePackage.Literals.LIST, 
					Util.getSupplierFactoryClass(InputStream.class), 
					classLoader, 
					ListSupplierFactoryAdapter::new));		
				
	}
	
}
