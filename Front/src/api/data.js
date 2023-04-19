import  axios from 'axios';

//接口封装
export  const getMenu=(param)=>{
    return axios.request({
        url:'/permissions/getMenu',
        method :'post',
        data : param
    })
}

export  const  getData= () => {
    return axios.request({
        url:'/home/getData',
    })
}

//Request for all order
export  const  getAllOrder= () => {
    return axios.request({
        url:'http://localhost:8088/order',
    })
}

export  const  getAllValues= () => {
    return axios.request({
        url:'http://localhost:8088/value',
    })
}

export  const  getTransById = (param) => {
    return axios.request({
        url:'http://localhost:8088/trans/'+param,
    })
}

export  const  getSelectedTrans = (param) => {
    return axios.request({
        url:'http://localhost:8088/trans/select/'+param,
    })
}

export  const  getAllTrans = () => {
    return axios.request({
        url:'http://localhost:8088/trans',
    })
}

export  const  getAllAccountStk = () => {
    return axios.request({
        url:'http://localhost:8088/account_stk',
    })
}

export  const  getAllOrder_detail = () => {
    return axios.request({
        url: 'http://localhost:8088/order_detail',
    })
}

export  const  selectSell = () => {
    return axios.request({
        url:'http://localhost:8088/order_detail/select/sell',
    })
}

export  const  selectBuy = () => {
    return axios.request({
        url:'http://localhost:8088/order_detail/select/buy',
    })
}


