//Отрисовка компонента телефона
function drawPgoneTag(index, types_list){
    return `<div id="phones[${index}]">
                    <input name="phones[${index}].number" type="text"/>
                    <label for="phoneType">Тип телефона</label>
                    <select id="phoneType" name="phones[${index}].phoneType" required>
                        ${types_list.map((e,idx)=> `<option value=${e.id}>${e.typeName}</option>`)}
                    </select>
                    <button onclick="removeItem('phones[${index}]')" class="removeBtn">Удалить</button>
                </div>`
}
//Удаление телефона из списка и перезаписывание всех аттрибутов
// Пример: есть 2 телефона с индексами 0,1,2. Удаляется индекс 0. Нужно, чтобы 1,2 стали 0,1 и данные корректно отправились на сервер.
function removeItem(id){
    $(`div[id='${id}']`).remove();
    $("#phones-container > div").each( (i, phoneDiv) =>{
        $(phoneDiv).attr("id", `phones[${i}]`);
        $(phoneDiv).children().each((ch_i, element)=>{
            if(element.attributes.id && element.attributes.id.nodeValue.includes("id"))
                $(element)
                    .attr("id",`phones${i}.id`)
                    .attr("name",`phones[${i}].id`)
            if(element.attributes.id && element.attributes.id.nodeValue.includes("number"))
                $(element)
                    .attr("id",`phones${i}.number`)
                    .attr("name",`phones[${i}].number`)
            if(element.attributes.id && element.attributes.id.nodeValue.includes("phoneType"))
                $(element)
                    .attr("name",`phones[${i}].phoneType`)
            if(element.className && element.className.includes("removeBtn")) {
                $(element).removeAttr("onclick");
                $(element).off("click");
                $(element).on("click",  () => {
                    removeItem(`phones[${i}]`)
                });
            }
        })
    });
}


$(document).ready(()=>{
    var types = [];
    $.get("/type/list", (data, status) => {
        types = data;
    });

    $("#person_form").submit((e)=>{
        //Отменить отправку формы на сервер, если произошло нажатие на кнопку 'удалить'
        if(e.originalEvent.submitter.className==="removeBtn")
            e.preventDefault();
    });

    $("#add_phone").click(()=> {
        let childrenCount = $("#phones-container div").length
        let index = childrenCount === 0 ? 0 : childrenCount;
        console.log(types);
        console.log(index);
        $("#phones-container").append(drawPgoneTag(index, types));
    });
});