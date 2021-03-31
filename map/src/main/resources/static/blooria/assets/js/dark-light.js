if (typeof (Storage) !== 'undefined') {
    if (localStorage.getItem('selected-theme') == 'light') {
        document.documentElement.setAttribute('data-theme', 'light');
    }
    else if (localStorage.getItem('selected-theme') == 'dark') {
        document.documentElement.setAttribute('data-theme', 'dark');
    }
}