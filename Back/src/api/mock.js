import Mock from 'mockjs'
import homeApi from '../mock/home'
// paras: API，DATA，
Mock.mock('/home/getData',homeApi.getStatisticalData)
Mock.mock('/home/getAll',homeApi.getStatisticalData)
