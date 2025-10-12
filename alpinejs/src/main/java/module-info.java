import org.nasdanika.models.html.alpinejs.AlpineJsFactory;
import org.nasdanika.models.html.alpinejs.impl.DefaultAlpineJsFactory;

module org.nasdanika.models.html.alpinejs {
		
	requires transitive org.nasdanika.models.html;
	requires org.apache.commons.text;
	
	exports org.nasdanika.models.html.alpinejs;
	exports org.nasdanika.models.html.alpinejs.impl;
	
	provides AlpineJsFactory with DefaultAlpineJsFactory;
	
}
