package org.example

import java.security.MessageDigest

//import sun.misc.BASE64Encoder
//import sun.misc.CharacterEncoder

class SHACodec {
	
	static encode = {target->
		MessageDigest md = MessageDigest.getInstance('SHA')
		md.update(target.getBytes('UTF-8'))
		return new String(md.digest()).encodeAsBase64()
	}
	
	/* this works too!  - requires two extra imports though
	static encode = { str ->
		MessageDigest md = MessageDigest.getInstance('SHA')
		md.update(str.getBytes('UTF-8'))
		return (new BASE64Encoder()).encode(md.digest())
	}*/
}