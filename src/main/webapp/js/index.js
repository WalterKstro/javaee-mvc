/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const btnSubmit = document.querySelector('#btn__register') ? document.querySelector('#btn__register') : null;

if (btnSubmit !== null) {
    const form = document.querySelector('#form__register');
    btnSubmit.addEventListener('click', e => {
        form.submit()
    })
}