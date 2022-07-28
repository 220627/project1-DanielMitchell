const url = "http://localhost:3000";
document.getElementById("getReimbursementButton").onclick = getReimbursements;
document.getElementById("sortReimbBtn").onclick = sortTable;

async function getReimbursements() {
  let response = await fetch(url + "/ers_reimbursement");

  console.log(response);

  if (response.status === 200) {
    let data = await response.json();
    console.log(data);
    // document.getElementById("reimbBody").innerHTML = "";

    var data1 = [];
    for (let reimb of data) {
      data1.push({
        ID: reimb.reimb_id,
        Amount: reimb.reimb_amount,
        Submitted: reimb.reimb_submitted,
        Description: reimb.reimb_description,
        Author: reimb.reimb_author,
        Resolver: reimb.reimb_resolver,
        Status: reimb.reimbursement_status.reimb_status,
        Type: reimb.reimbursement_type.reimb_type,
      });
    }
    console.log(data1);

    generateTable(data1);
  } else {
    alert("Something went wrong! Check your server and database connections");
  }
} //End of getReimbursements()

function generateTable(data) {
  $("#reimbTable").DataTable({
    data: data,
    columns: [
      { data: "ID" },
      { data: "Amount" },
      { data: "Submitted" },
      { data: "Description" },
      { data: "Author" },
      { data: "Resolver" },
      { data: "Status" },
      { data: "Type" },
    ],
  });
}

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
      if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
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
