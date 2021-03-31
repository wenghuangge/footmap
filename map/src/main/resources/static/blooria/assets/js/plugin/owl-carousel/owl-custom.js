(function($) {
    // USE STRICT
    "use strict";

    $(document).ready(function() {
        var owlSelector = $(".owl-carousel");
        owlSelector.each(function() {
            var option = {
                items: 1,
                margin: 0,
                loop: false,
                center: false,
                mousedrag: true,
                touchdrag: true,
                pulldrag: true,
                nav: true,
                dots: true,
                dotsdata: false,
                autoplay: false,
                smartspeed: 650,
                animateout: 'fadeOut',
                animatein: null,
                autoHeight: true,
                xs: 1,
                sm: 1,
                md: 1,
                lg: 1,
            };
            for (var k in option) {
                if (option.hasOwnProperty(k)) {
                    if ($(this).attr("data-carousel-" + k) != null) {
                        option[k] = $(this).data("carousel-" + k);
                    }
                }
            }

            $(this).owlCarousel({
                items: option.items,
                margin: option.margin,
                loop: option.loop,
                center: option.center,
                mouseDrag: option.mousedrag,
                touchDrag: option.touchdrag,
                pullDrag: option.pulldrag,
                nav: option.nav,
                navText: option.navtext,
                dots: option.dots,
                dotsData: option.dotsdata,
                autoplay: option.autoplay,
                smartSpeed: option.smartspeed,
                animateIn: option.animatein,
                animateOut: option.animateout,
                autoHeight: option.autoHeight,
                responsive: {
                    // breakpoint from 0 up
                    0: {
                        items: option.xs,
                    },
                    // breakpoint from 768 up
                    480: {
                        items: option.sm,
                    },
                    // breakpoint from 768 up
                    768: {
                        items: option.md,
                    },
                    992: {
                        items: option.lg,
                    },
                    1200: {
                        items: option.items,
                    },
                },
                // Go to the next item
            });
            // Go to the next item
            $(".next").click(function() {
                owlSelector.trigger("next.owl.carousel");
            });
            // Go to the previous item
            $(".prev").click(function() {
                // With optional speed parameter
                // Parameters has to be in square bracket '[]'
                owlSelector.trigger("prev.owl.carousel", [300]);
            });
            // var i = 1
            // $('.owl-carousel .owl-dot').each(function() {
            //     if (i < 10) $(this).text(i)
            //     else $(this).text(i)
            //     i++
            // })
        });
    });
})(jQuery);