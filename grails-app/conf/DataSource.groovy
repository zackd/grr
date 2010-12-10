dataSource {
	pooled = true
	driverClassName = "org.hsqldb.jdbcDriver"
	username = "sa"
	password = ""
}
hibernate {
	cache.use_second_level_cache=true
	cache.use_query_cache=true
	cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		/*dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			url = "jdbc:hsqldb:mem:devDB"
		}*/
		dataSource {
			//pooled = true
		    dbCreate = "create-drop"
		    url = "jdbc:mysql://localhost/grr?useUnicode=true&characterEncoding=utf-8"
		    driverClassName = "com.mysql.jdbc.Driver"
		    //dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			//logSql = true
		    username = "grails"
		    password = "nsecure"
		}
	}
	test {
		/*dataSource {
	    	dbCreate = "create-drop"
			url = "jdbc:hsqldb:mem:testDb"
		}*/
		dataSource {
			//pooled = true
		    dbCreate = "create-drop"
		    url = "jdbc:mysql://localhost/grr?useUnicode=true&characterEncoding=utf-8"
		    driverClassName = "com.mysql.jdbc.Driver"
		    //dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			//logSql = true
		    username = "grails"
		    password = "nsecure"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:file:prodDb;shutdown=true"
		}
	}
}