package org.nasdanika.models.html.alpinejs.tests;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.nasdanika.models.html.HtmlFactory;
import org.nasdanika.models.html.Tag;
import org.nasdanika.models.html.alpinejs.AlpineJs;
import org.nasdanika.models.html.alpinejs.AlpineJsFactory;

public class TestAlpineJs {

	@Test
	public void testData() {		
		Tag container = HtmlFactory.eINSTANCE.createTag();
		container.setName("div");
		AlpineJsFactory alpineJsFactory = AlpineJsFactory.INSTANCE;
		AlpineJs<Tag> containerAlpineJs = alpineJsFactory.from(container);
		containerAlpineJs.data("{ open: false }");		
		System.out.println(container);
	}

	@Test
	public void testJsonData() throws IOException {
		Tag container = HtmlFactory.eINSTANCE.createTag();
		container.setName("div");
		AlpineJsFactory alpineJsFactory = AlpineJsFactory.INSTANCE;
		AlpineJs<Tag> containerAlpineJs = alpineJsFactory.from(container);
		JSONObject containerData = new JSONObject(); 
		containerData.put("name", "Nasdanika");
		containerAlpineJs.data(containerData);
		
		System.out.println(container);
	}

}
