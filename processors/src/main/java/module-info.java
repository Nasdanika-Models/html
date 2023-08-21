module org.nasdanika.models.html.processors {
		
	requires transitive org.nasdanika.html.model.html;
	requires transitive org.nasdanika.models.ecore.graph;
	
	exports org.nasdanika.models.html.processors;
	opens org.nasdanika.models.html.processors; // For loading resources
	
}
