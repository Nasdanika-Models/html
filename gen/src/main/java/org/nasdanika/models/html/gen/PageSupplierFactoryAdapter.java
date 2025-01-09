package org.nasdanika.models.html.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.nasdanika.common.CollectionCompoundConsumerFactory;
import org.nasdanika.common.Context;
import org.nasdanika.common.Function;
import org.nasdanika.common.ListCompoundSupplierFactory;
import org.nasdanika.common.MapCompoundSupplierFactory;
import org.nasdanika.common.MutableContext;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Supplier;
import org.nasdanika.common.SupplierFactory;
import org.nasdanika.emf.EObjectAdaptable;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLPage;
import org.nasdanika.models.html.Page;

public class PageSupplierFactoryAdapter extends AdapterImpl implements SupplierFactory<HTMLPage> {
	
	public static final String PAGE_PROLOG_PROPERTY = "page/prolog";
	public static final String PAGE_HEAD_PROPERTY = "page/head";
	public static final String PAGE_BODY_PROPERTY = "page/body";
	public static final String PAGE_EPILOG_PROPERTY = "page/epilog";

	public PageSupplierFactoryAdapter(Page page) {
		setTarget(page);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == SupplierFactory.class;
	}
	
	protected Function<Map<PagePart, List<Object>>, HTMLPage> createPageFunction(Context context) {
		return new Function<Map<PagePart, List<Object>>, HTMLPage>() {
			
			@Override
			public double size() {
				return 1;
			}
			
			@Override
			public String name() {
				return "HTML Page";
			}
			
			@Override
			public HTMLPage execute(Map<PagePart, List<Object>> pageParts, ProgressMonitor progressMonitor) {
				HTMLFactory htmlFactory = context.get(HTMLFactory.class, HTMLFactory.INSTANCE);
				Page semanticElement = (Page) getTarget();
				String pageName = context.interpolateToString(semanticElement.getName());
				HTMLPage ret = htmlFactory.page();
				ret.title(pageName);
				ret.lang(semanticElement.getLanguage());
				for (String styleseet: semanticElement.getStylesheets()) {
					ret.stylesheet(styleseet);
				}
				for (String script: semanticElement.getScripts()) {
					ret.script(script);
				}				
				
				for (Object prologElement: context.get(PAGE_PROLOG_PROPERTY, List.class)) {
					ret.prolog(prologElement);
				}
				for (Object prologElement: pageParts.get(PagePart.prolog)) {
					ret.prolog(prologElement);
				}
				
				for (Object headElement: context.get(PAGE_HEAD_PROPERTY, List.class)) {
					ret.head(headElement);
				}
				for (Object headElement: pageParts.get(PagePart.head)) {
					ret.head(headElement);
				}
				
				for (Object bodyElement: context.get(PAGE_BODY_PROPERTY, List.class)) {
					ret.body(bodyElement);
				}
				for (Object bodyElement: pageParts.get(PagePart.body)) {
					ret.body(bodyElement);
				}
				
				for (Object epilogElement: context.get(PAGE_EPILOG_PROPERTY, List.class)) {
					ret.epilog(epilogElement);
				}
				for (Object epilogElement: pageParts.get(PagePart.epilog)) {
					ret.epilog(epilogElement);
				}
				return ret;
			}
		};
		
	}
	
	public static enum PagePart {
		prolog,
		head,
		body,
		epilog
	}
	
	@Override
	public Supplier<HTMLPage> create(Context context) {
		Page page = (Page) getTarget();
		MutableContext mc = context.fork();
		mc.put(PAGE_PROLOG_PROPERTY, new ArrayList<>());
		mc.put(PAGE_HEAD_PROPERTY, new ArrayList<>());
		mc.put(PAGE_BODY_PROPERTY, new ArrayList<>());
		mc.put(PAGE_EPILOG_PROPERTY, new ArrayList<>());
		CollectionCompoundConsumerFactory<HTMLPage> buildFactory = new CollectionCompoundConsumerFactory<>("Builders", EObjectAdaptable.adaptToConsumerFactoryNonNull(page.getBuilders(), HTMLPage.class));
		
		MapCompoundSupplierFactory<PagePart, List<Object>> partsFactory = new MapCompoundSupplierFactory<>("Page parts");
		
		ListCompoundSupplierFactory<Object> prologFactory = new ListCompoundSupplierFactory<>("Prolog", EObjectAdaptable.adaptToSupplierFactoryNonNull(page.getProlog(), Object.class));
		partsFactory.put(PagePart.prolog, prologFactory);
		
		ListCompoundSupplierFactory<Object> headFactory = new ListCompoundSupplierFactory<>("Head", EObjectAdaptable.adaptToSupplierFactoryNonNull(page.getHead(), Object.class));
		partsFactory.put(PagePart.head, headFactory);
		
		ListCompoundSupplierFactory<Object> bodyFactory = new ListCompoundSupplierFactory<>("Body", EObjectAdaptable.adaptToSupplierFactoryNonNull(page.getBody(), Object.class));		
		partsFactory.put(PagePart.body, bodyFactory);
		
		ListCompoundSupplierFactory<Object> epilogFactory = new ListCompoundSupplierFactory<>("Epilog", EObjectAdaptable.adaptToSupplierFactoryNonNull(page.getEpilog(), Object.class));
		partsFactory.put(PagePart.epilog, epilogFactory);
		
		return partsFactory
			.then(this::createPageFunction)
			.then(buildFactory.asFunctionFactory()).create(mc);
	}	

}
