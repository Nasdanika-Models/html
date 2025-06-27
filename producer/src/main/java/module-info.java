import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.html.producer.HtmlProducerFactoryCapabilityFactory;

module org.nasdanika.models.html.producer {
		
	requires transitive org.nasdanika.html.producer;
	requires transitive org.nasdanika.models.html;
	
	exports org.nasdanika.models.html.producer;
	
	opens org.nasdanika.models.html.producer;
	
	provides CapabilityFactory with HtmlProducerFactoryCapabilityFactory;
	
}
