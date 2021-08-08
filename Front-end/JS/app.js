(function(){
  let getallbtn = document.querySelector("#getallbtn");
  
  let postbtn = document.querySelector("#postbtn");
  let putbtn = document.querySelector("#putbtn");
  let deletebtn = document.querySelector("#deletebtn");

  let post1 = document.querySelector("#post1");
  let post2 = document.querySelector("#post2");
  let post3 = document.querySelector("#post3");
  let putid = document.querySelector("#putid");
  let put1 = document.querySelector("#put1");
  let put2 = document.querySelector("#put2");
  let put3 = document.querySelector("#put3");
  let deleteid = document.querySelector("#deleteid");

  let getallpara = document.querySelector("#getallpara");
  let postpara=document.querySelector("#postpara");
  let putpara=document.querySelector("#putpara");
  let deletepara = document.querySelector("#deletepara");

  let getalltable = document.querySelector("#getalltable");
  let posttable = document.querySelector("#posttable");
  let puttable = document.querySelector("#puttable")

  /* make use of the delete skeleton and also js file from the Fetch API task*/
  /* URL is local host stuff defined by java controller */

  let myGetAll = function() {
      fetch(`http://localhost:1999/todo/readall`, {
          method: `get`})
          .then(res => res.json())
          .then(data =>{

              getalltable.innerHTML=``;

              let tablehead = document.createElement("tr");

              let idhead = document.createElement("th");
              idhead.textContent=`Id`;
              tablehead.append(idhead);

              let namehead = document.createElement("th");
              namehead.textContent=`Name`;
              tablehead.append(namehead);

              let deschead = document.createElement("th");
              deschead.textContent=`Priority`;
              tablehead.append(deschead);

              getalltable.append(tablehead);

              for (const element of data) {
                  let tablerow = document.createElement("tr");

                  let iddata = document.createElement("td");
                  iddata.textContent=element.id;
                  tablerow.append(iddata);
      
                  let namedata = document.createElement("td");
                  namedata.textContent=element.name;
                  tablerow.append(namedata);
      
                  let descdata = document.createElement("td");
                  descdata.textContent=element.priority;
                  tablerow.append(descdata);

                  getalltable.append(tablerow);

                  

              }

              console.log(data)
              getallpara.innerHTML(`data retrieved`);
          })
          .catch(err => console.log(`something went wrong with error message: ${err}`)) 

  }
  getallbtn.addEventListener("click",() => myGetAll(), false);

  let myPost = function() {
      fetch(`http://localhost:1999/todo/create`, {
          method:`post`,
          headers: {"Content-type": "application/json; charset=UTF-8"}, 
          body: JSON.stringify({
              name: post1.value,
              priority: post2.value,
          })
      })
      .then(res => res.json())
      .then((data) => {
          posttable.innerHTML=``;
          /*fill data into table*/
          let tablehead = document.createElement("tr");

          let idhead = document.createElement("th");
          idhead.textContent=`Id`;
          tablehead.append(idhead);

          let namehead = document.createElement("th");
          namehead.textContent=`Name`;
          tablehead.append(namehead);

          let deschead = document.createElement("th");
          deschead.textContent=`Priority`;
          tablehead.append(deschead);

          let tablerow = document.createElement("tr");

          let iddata = document.createElement("td");
          iddata.textContent=data.id;
          tablerow.append(iddata);

          let namedata = document.createElement("td");
          namedata.textContent=data.name;
          tablerow.append(namedata);

          let descdata = document.createElement("td");
          descdata.textContent=data.priority;
          tablerow.append(descdata);

          posttable.append(tablehead);
          posttable.append(tablerow);

          console.log(data)
          postpara.innerHTML=`To do created`;
      })
      .catch(err => console.log(`something went wrong with error message: ${err}`)) 

  }
  postbtn.addEventListener("click",() => myPost(), false);

  let myPut = function() {
      let id = document.querySelector("#putid").value
      fetch(`http://localhost:1999/todo/update/` + id, {
          method: `put`,
          headers: {"Content-type": "application/json; charset=UTF-8"}, 
          body: JSON.stringify({
              id: putid.value,
              name: put1.value,
              priority: put2.value,
          })
      })
      .then(res => res.json())
      .then((data) =>{
          /*fill data into table*/
          puttable.innerHTML=``;
          /*fill data into table*/
          let tablehead = document.createElement("tr");

          let idhead = document.createElement("th");
          idhead.textContent=`Id`;
          tablehead.append(idhead);

          let namehead = document.createElement("th");
          namehead.textContent=`Name`;
          tablehead.append(namehead);

          let deschead = document.createElement("th");
          deschead.textContent=`Priority`;
          tablehead.append(deschead);

          let tablerow = document.createElement("tr");

          let iddata = document.createElement("td");
          iddata.textContent=data.id;
          tablerow.append(iddata);

          let namedata = document.createElement("td");
          namedata.textContent=data.name;
          tablerow.append(namedata);

          let descdata = document.createElement("td");
          descdata.textContent=data.priority;
          tablerow.append(descdata);

          puttable.append(tablehead);
          puttable.append(tablerow);
          console.log(data);
          putpara.innerHTML=`To Do Updated`;
      })
      .catch(err => console.log(`something went wrong with error message: ${err}`)) 

  }
  putbtn.addEventListener("click",() => myPut(), false);

  let myDelete = function() {
     let id = document.querySelector("#deleteid").value
      
      fetch(`http://localhost:1999/todo/delete/` + id, {
          method: `delete`
      })
      .then(res => res.json())
      .then((data) =>{
          /*deletes automatically, return data to the table*/
          console.log(data)
          deletepara.innerHTML = `data with id: ${data.value} deleted`;
          
      })
      .catch(err => console.log(`something went wrong with error message: ${err}`)) 

  }
  deletebtn.addEventListener("click",() => myDelete(), false);

})();