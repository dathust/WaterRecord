
function  sendRequest(maTram, selectTor) {
    var url = "http://localhost:8080/WaterRecord/CustomerServletWeb?maTram=" + maTram;

    $.get(url, function (rs) {
        var newDoc = document.open("text/html", "replace");
        newDoc.write(rs);
        $("#mySelect option[value=" + maTram + "]").attr('selected', true);
        newDoc.close();
    });
}

function jumpTab(elements, tabIndex) {
    for (var i = 0; i < elements.length; i++) {
        if (elements[i].hasAttribute("class")) {
            elements[i].setAttribute("class", "");
        }
    }
    elements[tabIndex - 1].setAttribute("class", "active");
}

function showModalAddnewArea() {
    $("#tenTram").val("");
    $("input#tenTram").attr('placeholder', "nhập tên trạm");
    $("#diaChi").val("");
    $("input#diaChi").attr('placeholder', "nhập địa chỉ");
    $("input#action").val("addnewarea");
}

function editArea(maTram, tenTram, diaChi) {
    this.maTram = maTram;
    this.tenTram = tenTram;
    this.diaChi = diaChi;
}

function showInfoToModalEditArea(Area) {
    $("#maTram").val(Area.maTram);
    $("#tenTram").val(Area.tenTram);
    $("#diaChi").val(Area.diaChi);
    $("#action").val("editarea");
}

function deleteA(maTram) {
    var url = "http://localhost:8080/WaterRecord/AreaServletProcess?maTram=" + maTram + "&command=deleteArea";
    $.get(url, function (rs) {
        var newDoc = document.open("text/html", "replace");
        newDoc.write(rs);
        newDoc.close();
    });
}

function deleteArea(maTram) {
    var url = "http://localhost:8080/WaterRecord/AreaServletProcess?maTram=" + maTram + "&command=deleteArea";
    $.get(url, function (rs) {
        var newDoc = document.open("text/html", "replace");
        newDoc.write(rs);
        newDoc.close();
    });
}

function editCustomer(maKH, tenKH, tenKhac, diaChi, soDienThoai, maSoThue, maDongHo, maBangGia, maTram, tongChiSo, ghiChu) {
    this.maKH = maKH;
    this.tenKH = tenKH;
    this.tenKhac = tenKhac;
    this.diaChi = diaChi;
    this.soDienThoai = soDienThoai;
    this.maSoThue = maSoThue;
    this.maDongHo = maDongHo;
    this.maBangGia = maBangGia;
    this.maTram = maTram;
    this.tongChiSo = tongChiSo;
    this.ghiChu = ghiChu;
}
function showInfoToModalEdit(Customer) {

    $("#maKhachHang").val(Customer.maKH);
    $("#tenKhachHang").val(Customer.tenKH);
    $("#tenKhac").val(Customer.tenKhac);
    $("#diaChi").val(Customer.diaChi);
    $("#soDienThoai").val(Customer.soDienThoai);
    $("#maSoThue").val(Customer.maSoThue);
    $("#maDongHo").val(Customer.maDongHo);
    $("#selectCost option[value=" + Customer.maBangGia + "]").attr('selected', true);
    $("#selectArea option[value=" + Customer.maTram + "]").attr('selected', true);
    $("#tongChiSo").val(Customer.tongChiSo);
    $("#ghiChu").val(Customer.ghiChu);
    $("#action").val("editcustomer");
}

function showModalAddnewCustomer(maTram) {
    $("#tenKhachHang").val("");
    $("input#tenKhachHang").attr('placeholder', "nhập tên khách hàng");
    $("#tenKhac").val("");
    $("input#tenKhac").attr('placeholder', "nhập tên gọi khác");
    $("#diaChi").val("");
    $("input#diaChi").attr('placeholder', "nhập địa chỉ");
    $("#soDienThoai").val("");
    $("input#soDienThoai").attr('placeholder', "nhập số điện thoại");
    $("#maSoThue").val("");
    $("input#maSoThue").attr('placeholder', "nhập mã số thuế");
    $("#maDongHo").val("");
    $("input#maDongHo").attr('placeholder', "nhập mã đồng hồ");
    $("#selectArea option[value=" + maTram + "]").attr('selected', true);
    $("#ghiChu").val("");
    $("#tongChiSo").val("0");
    $("input#ghiChu").attr('placeholder', "nhập ghi chú");
    $("#action").val("addnewcustomer");
}


function deleteCustomer(maKH, maTram) {
    var url = "http://localhost:8080/WaterRecord/CustomerServletProcess?maKhachHang=" + maKH + "&maTram=" + maTram + "&command=deleteCustomer";
    $.get(url, function (rs) {
        var newDoc = document.open("text/html", "replace");
        newDoc.write(rs);
        $("#mySelect option[value=" + maTram + "]").attr('selected', true);
        newDoc.close();
    });
}

function sendIDArea(maTram, selectTor) {
    var url = "http://localhost:8080/WaterRecord/IndicationServletWeb?maTram=" + maTram + "&command=selectArea";

    $.get(url, function (rs) {
        $("#mySelectCus").replaceWith(rs);
    });
}

function sendIDCus(maKhachHang, selectTor) {
    var url = "http://localhost:8080/WaterRecord/IndicationServletWeb?maKhachHang=" + maKhachHang + "&command=selectCustomer";
    $.get(url, function (rs) {
        $("table").replaceWith(rs);
    });
}
function editIndication(maSG, maKH, tenKH, maNV, tenNV, chiSo, ngayGhiSo, ghiChu) {
    this.maSG = maSG;
    this.maKH = maKH;
    this.tenKH = tenKH;
    this.maNV = maNV;
    this.tenNV = tenNV;
    this.chiSo = chiSo;
    this.ngayGhiSo = ngayGhiSo;
    this.ghiChu = ghiChu;
}
function showInfoToModalEditIndication(Indication) {
    $("#maSoGhi").val(Indication.maSG);
    $("#maKhachHang").val(Indication.maKH);
    $("#tenKhachHang").val(Indication.tenKH);
    $("#maNhanVien").val(Indication.maNV);
    $("#tenNhanVien").val(Indication.tenNV);
    $("#chiSo").val(Indication.chiSo);
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear() + "-" + (month) + "-" + (day);
    $("#ngayGhi").val(today);
    $("input#ngayGhi").attr('disabled', "disabled");
    $("#ghiChu").val(Indication.ghiChu);
    $("#action").val("editindication");
}

function sendRequestEditIndication(maSoGhi, maKhachHang, maNhanVien, chiSo, ghiChu) {

    var url = "http://localhost:8080/WaterRecord/IndicationServletProcess?maSoGhi=" + maSoGhi + "&maKhachHang=" + maKhachHang + "&maNhanVien=" + maNhanVien + "&chiSo=" + chiSo + "&ghiChu=" + ghiChu + "&command=editindication";

    $.get(url, function (rs) {
        $("table").replaceWith(rs);

    });
}

function sendRequestShowDataBill(maTram, thang, nam) {
    var url = "http://localhost:8080/WaterRecord/BillServletWeb?maTram=" + maTram + "&thang=" + thang + "&nam=" + nam + "&command=getBill";
    $.get(url, function (rs) {
        $("table").replaceWith(rs);
    });
}

function sendRequestBill() {
    var selectTorArea = $("#mySelectArea");
    var selectTorMonth = $("#mySelectMonth");
    var selectTorYear = $("#mySelectYear");
    var area = selectTorArea.val();
    var month = selectTorMonth.val();
    var year = selectTorYear.val();
    if (month == 0 || year == 0) {
        selectTorMonth.on("change", function () {
            //reset options Month and Year
//                $("#selectedMonth").replaceWith("<option id=\"selectedMonth\" selected=\"selected\">Chọn tháng</option>");
            area = selectTorArea.val();
            month = selectTorMonth.val();
            if (year == 0) {
                selectTorYear.on("change", function () {
                    //reset options Month and Year
//                $("#selectedMonth").replaceWith("<option id=\"selectedMonth\" selected=\"selected\">Chọn tháng</option>");
                    year = selectTorYear.val();
                    sendRequestShowDataBill(area, month, year);
                   
                    
                });
            } else {
                sendRequestShowDataBill(area, month, year);
                
            }

        });
    } else {
        sendRequestShowDataBill(area, month, year);
        
    }
    selectTorMonth.on("change", function () {
        area = selectTorArea.val();
        month = selectTorMonth.val();
        year = selectTorYear.val();
        sendRequestShowDataBill(area, month, year);
        
    });
}

function seandRequestCreateBill(){
    var selectTorArea = $("#mySelectArea");
    var selectTorMonth = $("#mySelectMonth");
    var selectTorYear = $("#mySelectYear");
    var area = selectTorArea.val();
    var month = selectTorMonth.val();
    var year = selectTorYear.val();
    var url = "http://localhost:8080/WaterRecord/BillServletWeb?maTram=" + area + "&thang=" + month + "&nam=" + year + "&command=createBill";
    $.get(url, function (rs) {      
        $("table").replaceWith(rs);
    });
}

function resetStatusCustomer(){
  var url = "http://localhost:8080/WaterRecord/CustomerServletProcess?command=resetstatuscustomer";
    $.get(url);
}
