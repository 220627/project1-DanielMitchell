const url = "http://localhost:3000";
document.getElementById("getReimbursementButton").onclick = getReimbursements;

async function getReimbursements() {
  let response = await fetch(url + "/ers_reimbursement");

  console.log(response);

  if (response.status === 200) {
    let data = await response.json();
    console.log(data);

    for (let reimb of data) {
      let row = document.createElement("tr");

      let cell = document.createElement("td");
      cell.innerHTML = reimb.reimb_id;
      row.appendChild(cell);

      let cell2 = document.createElement("td");
      cell2.innerHTML = reimb.reimb_amount;
      row.appendChild(cell2);

      let cell3 = document.createElement("td");
      cell3.innerHTML = reimb.reimb_submitted;
      row.appendChild(cell3);

      let cell4 = document.createElement("td");
      cell4.innerHTML = reimb.reimb_description;
      row.appendChild(cell4);

      let cell5 = document.createElement("td");
      cell5.innerHTML = reimb.reimb_author;
      row.appendChild(cell5);

      let cell6 = document.createElement("td");
      cell6.innerHTML = reimb.reimb_resolver;
      row.appendChild(cell6);

      let status = reimb.reimbursement_status;
      let reimbStatus = status.reimb_status;
      let cell7 = document.createElement("td");
      cell7.innerHTML = reimbStatus;
      row.appendChild(cell7);

      let type = reimb.reimbursement_type;
      console.log(type);
      let reimbType = type.reimb_type;
      let cell8 = document.createElement("td");
      cell8.innerHTML = reimbType;
      row.appendChild(cell8);

      document.getElementById("reimbBody").appendChild(row);
    }
  } else {
    alert("Something went wrong! Check your server and database connections");
  }
} //End of getReimbursements()
