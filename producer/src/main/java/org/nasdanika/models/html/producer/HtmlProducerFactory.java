package org.nasdanika.models.html.producer;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.html.Producer;

public class HtmlProducerFactory {
			
	private Context context;

	public HtmlProducerFactory(Context context)  {
		this.context = context;
	}

	@org.nasdanika.common.Transformer.Factory
	public final Producer<Object> createTagProducer(
			org.nasdanika.models.html.Tag tag,
			boolean parallel,
			BiConsumer<EObject, BiConsumer<Producer<Object>,ProgressMonitor>> elementProvider, 
			Consumer<BiConsumer<Map<EObject, Producer<Object>>,ProgressMonitor>> registry,
			ProgressMonitor progressMonitor) {
		
		return new TagProducer(context, tag, elementProvider);
	}

	@org.nasdanika.common.Transformer.Factory
	public final Producer<String> createPageProducer(
			org.nasdanika.models.html.Page page,
			boolean parallel,
			BiConsumer<EObject, BiConsumer<Producer<Object>,ProgressMonitor>> elementProvider, 
			Consumer<BiConsumer<Map<EObject, Producer<Object>>,ProgressMonitor>> registry,
			ProgressMonitor progressMonitor) {
		
		return new PageProducer(context, page, elementProvider);
	}

	@org.nasdanika.common.Transformer.Factory
	public final Producer<Object> createScriptProducer(
			org.nasdanika.models.html.Script script,
			boolean parallel,
			BiConsumer<EObject, BiConsumer<Producer<Object>,ProgressMonitor>> elementProvider, 
			Consumer<BiConsumer<Map<EObject, Producer<Object>>,ProgressMonitor>> registry,
			ProgressMonitor progressMonitor) {
		
		return new ScriptProducer(context, script, elementProvider);
	}
	
}
