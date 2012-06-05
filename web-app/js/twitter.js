HandBag.Twitter = function(){};

HandBag.Twitter.prototype = {

    init: function(){

        this.configureBrandAutoComplete();

    },

    configureBrandAutoComplete: function(){

        var self = this;

        $('#brand').autocomplete({
            source: "twitter/brands"
        });

        $($('#brand').data("autocomplete").menu.element[0]).attr('id','brand-dropdown');

        $('#brand').bind('autocompleteselect', function(event,ui){

            self.configureProductAutoComplete(ui.item.value);
            $('#product').focus();

        });

    },

    configureProductAutoComplete: function(brand){

        $('#product').autocomplete({
            source: function(request, response){
                $.ajax({
                    url: 'twitter/products',
                    data: {term:request.term, brand:brand},
                    success: function(data){ response(data);}
                });
            }
        });

        $($('#product').data("autocomplete").menu.element[0]).attr('id','product-dropdown');

    }

};


var twitter = new HandBag.Twitter();
twitter.init();