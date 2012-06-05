class HandbagUrlMappings {

	static mappings = {

        "/statusupdate"                 (controller: "twitter", action: 'statusupdate')
        "/twitter/products"             (controller: "twitter", action: 'products')
        "/twitter/brands"               (controller: "twitter", action: 'brands')
		"/"                             (controller: "twitter", action: 'index')
		"500"                           (view: '/error')
        "404"                           (view: "/notfound")
	}
}
