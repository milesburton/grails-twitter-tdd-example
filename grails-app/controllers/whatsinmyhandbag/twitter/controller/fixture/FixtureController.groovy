package whatsinmyhandbag.twitter.controller.fixture

import whatsinmyhandbag.twitter.domain.Brand
import whatsinmyhandbag.twitter.domain.Product

class FixtureController {

    def addbrand(String brandName){

        new Brand(name:  brandName,
                id: new Random().nextInt(100),
                version:0,
                website: 'test',
                slug:'test',
                status:false,
                isNew:false,
                description:'test'
        ).save(flush: true)

        render Brand.count
    }

    def addproductforbrand(String brand, String productName){

        Brand selectedBrand = Brand.findByName(brand)

        Product product = new Product(
                id: new Random().nextInt(100),
                brandId: selectedBrand.id,
                name: productName,
                description: '',
                type: ''
        ).save(flush: true)

        render Product.count

    }

    def cleanup(){

        Product.list().each { it.delete() }
        Brand.list().each { it.delete() }
        render Brand.count
    }
}