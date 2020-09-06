function displayBrands(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {

        if(req.status === 200 && req.readyState ===4) {
            if(req.getResponseHeader("Content-Type") === "application/json") {
                console.log("Oh, look! Some JSON: " + req.responseText);
                // adding element to body - hello world example
                // let elem = document.createElement('div');
                // elem.textContent = "hello world";
                // document.body.appendChild(elem);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    // console.log(el); // prints whole element
                    console.log(el.brandName); // allows access to specific value


                    // adding title to the body of the page
                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    //let brandIdent = document.createElement('h5');
                    header.textContent = "Brand Name: " + el.brandName;
                    //brandIdent.textContent = "Brand ID: " + el.brandId;
                    elem.appendChild(header);
                    //elem.appendChild(brandIdent);
                    el.shoes.forEach(shoe => {
                        console.log(shoe) // print all shoes for each brand

                        let shoeName = document.createElement('p');
                        shoeName.setAttribute("id", "shoeNameP");

                        let shoeSize = document.createElement('p');
                        shoeSize.setAttribute("id", "shoeSizeP");

                        let shoeColour = document.createElement('p');
                        shoeColour.setAttribute("id", "shoeColourP");

                        let elemBreak = document.createElement('p');
                        elemBreak.setAttribute("id", "elemBreakP");

                        //let delBtn = document.createElement('button');
                        //delBtn.innerHTML = "DELETE SHOE";

                        shoeName.textContent = "Shoe Name: " + shoe.shoeName;
						shoeSize.textContent = "Size: " + shoe.shoeSize;
                        shoeColour.textContent = "Colour: " + shoe.shoeColour;
                        elemBreak.textContent = "   ------------------------------------------   ";
                        elem.appendChild(shoeName);
						elem.appendChild(shoeSize);
                        elem.appendChild(shoeColour);
                        //elem.appendChild(delBtn);
                        elem.appendChild(elemBreak);

                        //delBtn.onclick = deleteShoe();
                    })
                    document.body.appendChild(elem);
                });

            } else {
                console.log("Looks like it's not JSON, but let's see what it is..." + req.responseText);
                
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://35.242.170.152:8080/getAllBrands");
    req.send();
}

function addBrand(){
    //Get data from form and assign key value pairs
    let elements = document.getElementById("brandsForm").elements;
    let obj = {};
    for(let i = 0; i < elements.length - 1; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://35.242.170.152:8080/addBrand");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify(
        {
            brandName: obj.brandName
        }
        )
        );

}

function addShoe(){
    let elements = document.getElementById("shoeForm").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://35.242.170.152:8080/addShoe");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify(
        { 
            shoeName: obj.shoeName, 
            shoeSize: obj.shoeSize, 
            shoeColour: obj.shoeColour,
            brand:
                { 
                    brandId: Number(obj.brandId)} 
        }

    )
    );
}

function updateShoe(){
    //Get data from form and assign key value pairs
    let elements = document.getElementById("updateShoeForm").elements;
    let obj = {};
    for(let i = 0; i < elements.length; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    console.log("http://35.242.170.152:8080/updateShoeSize/" + obj.shoeId)
    req.open("PUT", "http://35.242.170.152:8080/updateShoeSize/" + obj.shoeId);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify(
        {
            shoeSize: obj.shoeSize
        }

        )
    );
}

function deleteShoe(){
    //Get data from form and assign key value pairs
    let elements = document.getElementById("deleteShoeForm").elements;
    let obj = {};
    for(let i = 0; i < elements.length - 1; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    console.log("http://35.242.170.152:8080/delete/" + Number(obj.shoeId))
    req.open("DELETE", "http://35.242.170.152:8080/delete/" + Number(obj.shoeId));
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let myJson = req.send(JSON.stringify(
        { 
            shoeId: obj.shoeId
        }

    )
    );
    delete myJson;
}

function deleteBrand(){
    //Get data from form and assign key value pairs
    let elements = document.getElementById("deleteBrandForm").elements;
    let obj = {};
    for(let i = 0; i < elements.length - 1; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    console.log("http://35.242.170.152:8080/deleteBrand/" + Number(obj.brandId))
    req.open("DELETE", "http://35.242.170.152:8080/deleteBrand/" + Number(obj.brandId));
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let myBrandJson = req.send(JSON.stringify(
        {
            brandId: obj.brandId
        }

        )
    );
    delete myBrandJson;
}