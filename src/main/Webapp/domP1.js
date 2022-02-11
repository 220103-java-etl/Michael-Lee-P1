
let ReimUrl = "http://localhost:8080/ERS-P1-Michael_Lee/reimbursements";


/*
function getReimbyId(){

    let searchInput = document.getElementById('').value;

    

    let AddReim() = {
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
*/

function getAllReim(){

    let xhr = new XMLHttpRequest();


    xhr.onreadystatechange = function() {
        console.log(this.readyState)
        if (this.readyState == 4 && this.status == 200) {
            let r = JSON.parse(this.responseText);
            console.log(r)
            populateReim(r);
        }
    }

    xhr.open('GET', ReimUrl, true);

    xhr.send();
}

function getAllReim(){

    let xhr = new XMLHttpRequest();


    xhr.onreadystatechange = function() {
        console.log(this.readyState)
        if (this.readyState == 4 && this.status == 200) {
            let r = JSON.parse(this.responseText);
            console.log(r)
            populateReim(r);
        }
    }

    xhr.open('GET', ReimUrl, true);

    xhr.send();
}


function populateReim(data){
    let reimDiv = document.getElementById('getAllSearchDiv');
    reimDiv.innerHTML = "";
    
    let getAllSearchTable = document.createElement('table');
    getAllSearchTable.setAttribute('class', 'table')

    let tHead = document.createElement('thead');

    let tableHeaderRow = document.createElement('tr');

    let tHeaders = ['ID', 'Amount($)', 'Status','Author ID','Resolver ID','Date Submitted','Type','Grade Criteria','Description','Message'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.setAttribute('scope', 'col');
        th.innerHTML = h;
        tableHeaderRow.append(th);
    }
    tHead.append(tableHeaderRow)
    getAllSearchTable.append(tHead);

    for (let reim of data) { // for (String s : strArray)
        let tr = document.createElement('tr');
        tr.id = reim.id;
        
        let tdID = document.createElement('td');
        tdID.innerHTML = reim.id;
        tr.append(tdID);

        let tdAmount = document.createElement('td');
        //tdAmount.id = reim.amount.id;
        tdAmount.innerHTML = reim.amount;
        tr.append(tdAmount);

        let tdStatus = document.createElement('td');
        //tdStatus.id = reim.status.id;
        tdStatus.innerHTML = reim.status;
        tr.append(tdStatus);

        let tdAuthorID = document.createElement('td');
        //tdAuthorID.id = reim.authorID;
        tdAuthorID.innerHTML = reim.authorId;
        tr.append(tdAuthorID);

        let tdResolverID = document.createElement('td');
        //tdResolverID.id = reim.tdResolverID.id;
        tdResolverID.innerHTML = reim.resolverId;
        tr.append(tdResolverID);

        let tdDate = document.createElement('td');
        tdDate.innerHTML = reim.date;
        tr.append(tdDate);

        let tdType = document.createElement('td');
        tdType.innerHTML = reim.type;
        tr.append(tdType);

        let tdGrade = document.createElement('td');
        tdGrade.innerHTML = reim.grade;
        tr.append(tdGrade);

        let tdDescription = document.createElement('td');
        tdDescription.innerHTML = reim.description;
        tr.append(tdDescription);

        let tdMessage = document.createElement('td');
        tdMessage.innerHTML = reim.message;
        tr.append(tdMessage);



        let tdButtonApprove = document.createElement('td');
        tdButtonApprove.innerHTML = `<button type="button" onclick="updateApprove(event)">Approve</button>`;
        tr.append(tdButtonApprove);
        
        let tdButtonDeny = document.createElement('td');
        tdButtonDeny.innerHTML = `<button type="button" onclick="updateDeny(event)">Deny</button>`;
        tr.append(tdButtonDeny);

        getAllSearchTable.append(tr);
    }

    getAllSearchDiv.append(getAllSearchTable);
    

}
// this is the update function part of our table 
function updateApprove(event) {
    //console.log(event);
    console.log(event.path[2])
    let ReimRow = event.path[2]; // this is the <tr> element

    let updatedReim = {

        id: Number(ReimRow.cells[0].innerHTML),
        status: "APPROVED",
        resolverId: Number(ReimRow.cells[4].innerHTML)
        /*
        id: ReimRow.id,
        resolverId: ReimRow.resolverId,
        status: "APPROVED",
        amount: ReimRow.amount,
        authorId: ReimRow.authorId,
        date: ReimRow.date,
        description: ReimRow.description,
        grade: ReimRow.grade,
        message: ReimRow.message,
        type: ReimRow.type
        */
    }

    console.log(updatedReim);

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    }

    xhr.open('PUT', ReimUrl, true);

    xhr.send(JSON.stringify(updatedReim));
}

function updateDeny(event) {
    console.log(event);
    let ReimRow = event.path[2]; // this is the <tr> element

    let updatedReim = {
       
        id: Number(ReimRow.cells[0].innerHTML),
        status: "DENIED",
        resolverId: Number(ReimRow.cells[4].innerHTML)

        
    }

    console.log(updatedReim);

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    }

    xhr.open('PUT', `${ReimUrl}/${ReimRow.id}`, true);

    xhr.send(JSON.stringify(updatedReim));
}

