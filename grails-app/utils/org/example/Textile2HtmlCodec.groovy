package org.example

import org.eclipse.mylyn.wikitext.core.*
import org.eclipse.mylyn.wikitext.textile.*

class Textile2HtmlCodec {
	
	static encode = {target->
		MarkupParser markupParser = new MarkupParser();
		markupParser.setMarkupLanaguage(new TextileLanguage());
		String htmlContent = markupParser.parseToHtml(target);
		return htmlContent
	}
	
	static decode = {target->
		return "textile"
	}
}