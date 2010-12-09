package org.example

/*
http://www.jarvana.com/jarvana/view/org/fusesource/wikitext/wikitext-core/1.0/wikitext-core-1.0-javadoc.jar!/overview-tree.html
*/

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage

class Textile2HtmlCodec {
	static encode = {target->
		MarkupParser parser = new MarkupParser(new TextileLanguage());
		parser.parseToHtml(String.valueOf(target));
	}
	/*
	static decode = {target->
		MarkupParser parser = new MarkupParser(new ***** Language());
		parser.parseTo******(String.valueOf(target));
	}*/
}
