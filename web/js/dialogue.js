function deleteClick() {
    var con;
    con = confirm("Are you sure you want to delete?\n");
    if (con == true) {
        window.location.href = "admin.jsp";
    }
}