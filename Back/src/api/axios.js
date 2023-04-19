import  axios from 'axios';
import  config from './config';

const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro

class HttpRequest {
    constructor(baseUrl) {
        this.baseUrl = baseUrl;
    }
    //定义axios相关配置
    getInsideConfig() {
        const config = {
            baseUrl:this.baseUrl,
            header : {}
        }
        return config;
    }
    //对axios实例instance进行拦截
    interceptors(instance){
        //请求拦截器
        instance.interceptors.request.use(function(config){
            return config
        },function (error){
            return Promise.reject(error);
        });
        //响应拦截器,在post中捕获用户的异常操作
        instance.interceptors.response.use(function(response){
            console.log('response')
            return response
        },function (error){
            console.log('error')
            return Promise.reject(error);
        });
    }
    //根据option配置
    request(options){
        const instance = axios.create();
        options = {...this.getInsideConfig(),...options}
        this.interceptors(instance);
        return instance(options)
    }
}

//向外暴露
new HttpRequest(baseUrl);
