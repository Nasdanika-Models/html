import org.nasdanika.capability.CapabilityFactory;
import org.nasdanika.models.html.util.HtmlEPackageResourceSetCapabilityFactory;

module org.nasdanika.models.html {
		
	requires transitive org.nasdanika.html;
	requires transitive org.nasdanika.exec;
	
	exports org.nasdanika.models.html;
	exports org.nasdanika.models.html.impl;
	exports org.nasdanika.models.html.util;
	
	provides CapabilityFactory with HtmlEPackageResourceSetCapabilityFactory;
	
}
