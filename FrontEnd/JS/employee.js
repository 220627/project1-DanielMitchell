const url = "http://localhost:3000";
document.getElementById("getReimbursementButton").onclick = getReimbursements;
async function getReimbursements() {
  let response = await fetch(url + "/ers_reimbursement");

  console.log(response);

  if (response.status === 200) {
    let data = await response.json();
    console.log(data);

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
}

function submitReimbursement() {
  $.ajax({
    url: url + "/ers_reimbursement",
    type: "PUT",
    data: JSON.stringify({
      reimb_amount: $("input[name='amount']").val(),
      reimb_description: $("input[name='description']").val(),
      reimb_author: $("input[name='author']").val(),
      reimb_type_id_fk: $("select[name='type']").val(),
    }),
    success: function (result) {
      location.reload();
    },
  });
}

function generateTable(data) {
  $("#reimbTable").DataTable({
    data: data,
    columns: [
      { data: "ID", title: "Reimb. ID" },
      { data: "Amount", title: "Amount (USD)" },
      { data: "Submitted", title: "Date/Time Submitted" },
      { data: "Description", title: "Description" },
      { data: "Author", title: "Author ID" },
      { data: "Status", title: "Status" },
      { data: "Type", title: "Type" },
    ],
  });
} //End of table generation
