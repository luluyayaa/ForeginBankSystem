import mock from 'js'
import homeApi from '..//home'
// paras: API，DATA，
mock('/home/getData',homeApi.getStatisticalData)
mock('/home/getAll',homeApi.getStatisticalData)
