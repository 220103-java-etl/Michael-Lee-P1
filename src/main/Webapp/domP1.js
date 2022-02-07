
function SearchReim(){

    let searchInput = document.getElementById('reim_id').value;

    let url = "http://localhost:8080/ERS-P1-Michael_Lee/reimbursements"

    let searchReim = {
        reim_id : searchInput
    }
    let searchJson = JSON.stringify(searchReim)

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            
        }
    }

    xhr.open('PUT',url,true);

    xhr.setRequestHeader('Content-Type','application/json');

    xhr.send(searchJson)

}
