package whatsinmyhandbag.twitter.domain
class Brand {

     static mapping = {
         table 'brand'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'id'
    }

    Long id
    Long version
    String name
    String website
    String slug
    Boolean status
    Boolean isNew
    String description

    static constraints = {
        id(max: 9223372036854775807L)
        version(max: 9223372036854775807L)
        name(size: 1..255, blank: false)
        website(size: 0..255)
        slug(size: 1..255, blank: false)
        status()
        isNew(nullable: true)
        description()
    }

    String toString() {
        return "${id}" 
    }
}
