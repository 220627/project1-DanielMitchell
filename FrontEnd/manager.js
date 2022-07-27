const url = "http://localhost:3000";
document.getElementById("getReimbursementButton").onclick = getReimbursements;
document.getElementById("sortReimbBtn").onclick = sortTable;

async function getReimbursements() {
  let response = await fetch(url + "/ers_reimbursement");

  console.log(response);

  if (response.status === 200) {
    let data = await response.json();
    console.log(data);
    document.getElementById("reimbBody").innerHTML = "";
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
  /*let data = await response.json();
  console.log(data);
  $(document).ready(function () {
    $("#reimbTable").DataTable();
  });*/
} //End of getReimbursements()
function sortTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("reimbTable");
  switching = true;
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < rows.length - 1; i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[6];
      y = rows[i + 1].getElementsByTagName("TD")[6];
      // Check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        // If so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
