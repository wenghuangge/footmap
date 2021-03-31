(function($) {
    var allfunction = {
        preloader: () => {
            $('body').removeClass('placeholder');
    $('.loader-wrapper').addClass('hideen');
            //var count = 0;
            //var counter = setInterval(function() {
            //    if (count <= 101) {
            //        $('.count').text(count + '%');
            //        $('.loader, .loader2').css('width', count + '%');
            //        if (count == 100) {
            //            $('body').removeClass('placeholder')
            //            $('.loader-wrapper').addClass('hideen')
            //        }
            //        count++
            //    } else {
            //        clearInterval(counter)
            //    }
            //}, 20)
        },
        // sticky menu js code here
        sticky_menu: function() {
            $(window).on("scroll", function() {
                var $this = ".header-area";
                var scrollDistance = $(window).scrollTop();
                var topOffset = $($this).position().top + 50;
                var showSticky = $($this).position().top + 500;
                if (topOffset <= scrollDistance) {
                    $($this).addClass("sticky");
                } else if (showSticky <= scrollDistance) {
                    $($this).addClass("show-sticky");
                } else {
                    $($this).removeClass("sticky show-sticky");
                }
            });
        },
        // MainMenu funstions
        mainmenu: () => {
            $('.menu-bar ul li').each(function() {
                if ($(this).children('ul').length) {
                    $(this).children('a').append('<i class= "icofont-thin-down icon-hidden-md"></i><div class="drop-icon"><span class="icofont-minus"></span><span class="icofont-plus"></span></div>');
                }

            })
            $('.menu-bar ul li').click(function(e) {
                e.stopPropagation();
                $(this).children('a').next().toggleClass('active');
                $(this).children('a').toggleClass('active');
                $(this).siblings('li').children('a').next().removeClass('active');
                $(this).siblings('li').children('a').removeClass('active');
            })
        },
        input_click: function() {

            if ($('.input-group-icon input').length) {
                $(".input-group-icon input").on("click", function(e) {
                    e.stopPropagation()
                    $(this).parent('.input-group-icon').addClass('active')
                });
            }
            if ($('.sign-in-card').length) {
                $(".sign-in-card").on("click", function(e) {
                    e.stopPropagation()
                    $('.input-group-icon').removeClass('active')
                });
            }

        },
        delous: function() {
            if ($('.single-blog-full-content').length) {
                (function() {
                    var d = document,
                        s = d.createElement('script');
                    s.src = 'https://bolloria-2.disqus.com/embed.js';
                    s.setAttribute('data-timestamp', +new Date());
                    (d.head || d.body).appendChild(s);
                })();
            }
        },
        sign_in_click: function() {
            $(".sign-click").on("click", function(e) {
                e.stopPropagation()
                $(this).children('.sign-in-card').addClass('active')
                $('body, .header-area').addClass('active')
            });
            $("body").on("click", function() {
                $(this).removeClass('active')
                $('.sign-in-card ,  .header-area').removeClass('active')
            });
        },
        dropdawn_click: function() {
            $(".menu-show").on("click", function(e) {
                e.stopPropagation()
                $(this).addClass('active')
                $(this).next('.menu-close').addClass('active')
                $(this).parents('.header-area').find('.menu-bar').addClass('active')
                $('body , .header-area').addClass('active')
            });
            $(".menu-close, body").on("click", function(e) {
                e.stopPropagation()
                $('.menu-close').removeClass('active')
                $('.menu-show').removeClass('active')
                $('.header-area').find('.menu-bar').removeClass('active')
                $('body , .header-area').removeClass('active')
            });
        },
        video_popup: function() {
            // Video popup
            if ($('#video-popup').length) {
                const videoPopup = () => {
                    var a = $("#video-popup");
                    var configObject = {
                        sourceUrl: a.attr("data-videourl"),
                        triggerElement: "#" + a.attr("id"),
                        progressCallback: function() {
                            console.log("Callback Invoked.");
                        }
                    };

                    var videoBuild = new YoutubeOverlayModule(configObject);
                    videoBuild.activateDeployment();
                };
                videoPopup();
                hljs.initHighlightingOnLoad();
            }
        },
        product_dtls: function() {
            if ($('.nav-item a').length) {
                $('.nav-item a').on('click', function(e) {
                    e.preventDefault()
                    $(this).tab('show')
                })
            }
            if ($('.product-information-img').length) {
                $(".owl-carousel").owlCarousel({
                    loop: true,
                    items: 1,
                    margin: 0,
                    stagePadding: 0,
                    autoplay: false
                });

                dotcount = 1;

                jQuery('.owl-dot').each(function() {
                    jQuery(this).addClass('dotnumber' + dotcount);
                    jQuery(this).attr('data-info', dotcount);
                    dotcount = dotcount + 1;
                });

                slidecount = 1;

                jQuery('.owl-item').not('.cloned').each(function() {
                    jQuery(this).addClass('slidenumber' + slidecount);
                    slidecount = slidecount + 1;
                });

                jQuery('.owl-dot').each(function() {
                    grab = jQuery(this).data('info');
                    slidegrab = jQuery('.slidenumber' + grab + ' img').attr('src');
                    jQuery(this).css("background-image", "url(" + slidegrab + ")");
                });

                amount = $('.owl-dot').length;
                gotowidth = 100 / amount;
                jQuery('.owl-dot').css("height", gotowidth + "%");
            }
        },
        searchbox_active: function() {
            $('.popup').on('click', function(e) {
                e.stopPropagation()
                $('.search-popup-area').addClass('popup-show')
            })
            $('.popup-close-icon').on('click', function() {
                $('.search-popup-area').removeClass('popup-show')
            })
            $('.search-box input').on('click', function(e) {
                e.stopPropagation()
                $('.data-list-wrapper ul').addClass('active')

                $('#search').hideseek({
                    highlight: true,
                    nodata: 'No results found',
                })
            })
            $('.search-box input').on('keyup', function(e) {
                if ($(this).val() !== '') {
                    $('.data-list').addClass('active')
                    $(this).addClass('active')
                } else {
                    $('.data-list').removeClass('active')
                    $(this).removeClass('active')
                }
            })
        },
        isotop: () => {
            if ($('.grid').length) {
                var $grid = $('.grid').isotope({
                    itemSelector: '.grid-item',
                    percentPosition: true,
                    masonry: {
                        horizontalOrder: true
                    }
                });
                $grid.imagesLoaded().progress(function() {
                    $grid.isotope('layout')
                });
            }
        },
        // IMG to SVG
        imgToSvg: function() {
            function jetix_svg() {
                jQuery('img').each(function() {
                    var jQueryimg = jQuery(this);
                    var imgClass = jQueryimg.attr('class');
                    var imgURL = jQueryimg.attr('src');
                    jQuery.get(imgURL, function(data) {
                        // Get the SVG tag, ignore the rest
                        var jQuerysvg = jQuery(data).find('svg');

                        // Add replaced image's classes to the new SVG
                        if (typeof imgClass !== 'undefined') {
                            jQuerysvg = jQuerysvg.attr('class', imgClass + ' replaced-svg');
                        }
                        jQuerysvg = jQuerysvg.removeAttr('xmlns:a');
                        // Replace image with new SVG
                        jQueryimg.replaceWith(jQuerysvg);

                    }, 'xml');

                });
            }
            $(document).each(function() {
                jetix_svg();
            })
        },
        dark_light: () => {
            /** Dark Light Version*/
            var html = document.querySelector('html'),
                darkLight = document.querySelector('.dark-light')
            if (darkLight) {
                darkLight.addEventListener('click', function() {
                    if (html.getAttribute('data-theme') === 'light') {
                        html.setAttribute('data-theme', 'dark')
                        localStorage.setItem('selected-theme', 'dark');
                    } else {
                        html.setAttribute('data-theme', 'light')
                        localStorage.setItem('selected-theme', 'light');
                    }
                })
            }
        },
        // nice-select js
        nice_select: () => {
            if ($('.nice-select').length) {
                $('.nice-select').each(function() {
                    var select = $(this),
                        name = select.attr('name');

                    select.hide();

                    select.wrap('<div class="nice-select-wrap"></div>');

                    var parent = select.parent('.nice-select-wrap');

                    parent.append('<ul id=' + name + ' style="display:block"></ul>');

                    select.find('option').each(function() {

                        var option = $(this),
                            value = option.attr('value'),
                            label = option.text();

                        if (option.is(":first-child")) {

                            $('<a href="#" class="drop">' + label + '</a>').insertBefore(parent.find('ul'));

                        } else {

                            parent.find('ul').append('<li><a href="#" id="' + value + '">' + label + '</a></li>');

                        }

                    });

                    parent.find('a').on('click', function(e) {
                        e.stopPropagation()
                        parent.toggleClass('down').find('ul').toggleClass('active');
                        e.preventDefault();

                    });
                    $('body').on('click', function(e) {
                        e.stopPropagation()
                        parent.removeClass('down').find('ul').removeClass('active');

                    });
                    parent.find('ul a').on('click', function(e) {

                        var niceOption = $(this),
                            value = niceOption.attr('id'),
                            text = niceOption.text();

                        select.val(value);

                        parent.find('.drop').text(text);

                        e.preventDefault();

                    });

                });
            }
        },
        // StopPropagations elements
        stopPropagationElements: () => {
            $('.search-box input , .input-group-icon input, .sign-in-card , .menu-bar').on('click', function(e) {
                e.stopPropagation()
            })
        },
        // Document click to hide elements
        elementHide: () => {
            $(document).on('click', function() {
                $('.data-list, .input-group-icon, .sign-in-card').removeClass('active');
                // $('.dropdown').removeClass('active');
            })
        },
        init: function() {
            allfunction.preloader()
            allfunction.imgToSvg()
            allfunction.dark_light()
            allfunction.sticky_menu()
            allfunction.mainmenu()
            allfunction.searchbox_active()
            allfunction.input_click()
            allfunction.sign_in_click()
            allfunction.dropdawn_click()
            allfunction.isotop()
            allfunction.nice_select()
            allfunction.product_dtls()
            allfunction.video_popup()
            allfunction.delous()
            allfunction.elementHide()
            allfunction.stopPropagationElements()
        },
    }

    $(document).ready(function() {
        allfunction.init();
    });

})(jQuery);

$(window).load(function() {});
// spiners function start here
document.addEventListener('DOMContentLoaded', function() {
    var inputs = document.getElementsByClassName('input-number-wrapper')

    function incInputNumber(input, step) {
        var val = +input.value
        if (isNaN(val)) val = 0
        val += step
        input.value = val > 0 ? val : 0
    }
    Array.prototype.forEach.call(inputs, function(el) {
        var input = el.getElementsByTagName('input')[0]

        el.getElementsByClassName('increase')[0].addEventListener('click', function() { incInputNumber(input, 1) })
        el.getElementsByClassName('decrease')[0].addEventListener('click', function() { incInputNumber(input, -1) })
    })
})