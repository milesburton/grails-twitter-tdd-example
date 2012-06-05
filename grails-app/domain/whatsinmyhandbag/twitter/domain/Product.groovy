package whatsinmyhandbag.twitter.domain
class Product {

    static mapping = {
         table 'product'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'id'
    }
    Long id
    Long brandId
    String name
    String description
    String type

    static constraints = {
        id(max: 9223372036854775807L)
        brandId(nullable: true, max: 9223372036854775807L)
        name(size: 1..255, blank: false)

    }
    String toString() {
        return "${id}" 
    }
}
