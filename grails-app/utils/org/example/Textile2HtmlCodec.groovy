package org.example

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage

class Textile2HtmlCodec {
	static encode = {target->
		/*
		MarkupParser markupParser = new MarkupParser();
		markupParser.setMarkupLanaguage(new TextileLanguage());
		return markupParser.parseToHtml(target);
		*/
		
		MarkupParser parser = new MarkupParser(new TextileLanguage());
		parser.parseToHtml(String.valueOf(target));
	}
	
	static decode = {target->
		return "textile"
	}
}

//import com.plink.plextile.TextParser
