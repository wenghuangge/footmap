package com.wenghuangge.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.wenghuangge.bean.po.Photo;
import com.wenghuangge.bean.vo.PhotoMapVO;
import com.wenghuangge.mapper.PhotoMapper;
import com.wenghuangge.service.PhotoService;
import com.wenghuangge.utils.TimeUtils;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName footmap
 * @ClassName PhotoServiceImpl
 * @Date 2021/2/24 12:27
 * @Author wenghuangge
 * @Version 1.0
 */
@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {


    private PhotoMapper photoMapper;
    private ModelMapper modelMapper;
    @Autowired
    public PhotoServiceImpl(PhotoMapper photoMapper, ModelMapper modelMapper){
        this.photoMapper=photoMapper;
        this.modelMapper=modelMapper;
    }
    @Override
    public List<Photo> getMap(Integer userId) {
        List<Photo> photoList=photoMapper.getAllByUserId(userId);

        photoList.forEach(photo -> {

            List<String> list = JSONObject.parseArray(photo.getImgUrl(), String.class);
            photo.setImgList(list);
            photo.setSTime(TimeUtils.timeChange(photo.getTime()));
        });
        return photoList;
    }

    /**
     * 照片img转换成list形式
     * @param img
     * @return
     */
    public List<String> imgStringToList(String img){
        return JSONObject.parseArray(img, String.class);
    }
    @Override
    public List<Object> cal_palce(Integer userId, Long start_time, long end_time) {
        List<Photo> photoList = photoMapper.getAllByUserId(userId);
        List<Object> retString=new ArrayList<>();
        //经线 南北90  纬线东西180
        Double E=0.0,S=90.0,W=180.0,N=0.0;
        //去过最东南西北的省
        String[] Pro={"无","无","无","无"};
        //去过最东南西北的城市
        String[] Cit={"无","无","无","无"};
        //去过的省
        Map<String,Integer> vis_province = new HashMap<>();
        //去过的城市
        Map<String,Integer> vis_city = new HashMap<>();
        //去过最多次城市的照片
        String photo_url1="";
        //最近一次拍摄的照片
        String photo_url2="";
        //去过最东城市的照片
        String photo_url3="";
        //去过最南的城市的照片
        String photo_url4="";
        //去过最西的城市的照片
        String photo_url5="";
        //去过最北的城市的照片
        String photo_url6="";
        //去过最多的省以及城市
        String most_province="中国",most_city="家乡";
        //去过的城市
        List<String> cityList=new ArrayList<>();
        //去过的省份
        List<String> provinceList=new ArrayList<>();
        Integer valP=0,valC=0; //去过次数最多的城市和省的次数
        int cnt=0;
        long time=0;
        for(Photo photo:photoList){
            // todo: 照片时间筛选
            Long timeRange=photo.getTime();
            //不在时间范围内的跳过
            if(timeRange<start_time||timeRange>end_time){
                continue;
            }
            cnt++;
            Integer val=null;
            //去过最多的城市
            if(photo.getCity()!=null||photo.getProvince()!="") {
                val = vis_city.get(photo.getCity());
                String city = photo.getCity();
                Integer num = vis_city.get(city);
                if(num==null){
                    cityList.add(city);
                    num=0;
                }
                num+=1;
                if (num > valC) {
                    valC = num;
                    photo_url1 = photo.getImgUrl();
                    most_city=city;
                }
                vis_city.put(city, num);

            }
            val=null;
            //去过最多的省
            if(photo.getProvince()!=null||photo.getProvince()!="") {
                String province=photo.getProvince();
                Integer num=vis_province.get(province);
                if(num==null){
                    num=0;
                    provinceList.add(province);
                }
                num+=1;
                if(num>valP){
                    valP=num;
                    most_province=province;
                }
                vis_province.put(province, num);
            }

            //经线
            Double sn=photo.getLatitude();
            //纬线
            Double ew=photo.getLongitude();
            if (sn != null && ew != null){
                //去过最南的城市
                if(sn<S){
                    if(photo.getImgUrl()!=null){
                        photo_url4=photo.getImgUrl();
                    }
                    S=sn;
                    if(!photo.getProvince().equals("")) Pro[1]=photo.getProvince();
                    if(photo.getCity()!=null) Cit[1]=photo.getCity();
                }
                //去过最北的城市
                if(sn>N){
                    N=sn;
                    if(photo.getImgUrl()!=null){
                        photo_url6=photo.getImgUrl();
                    }
                    if(!photo.getProvince().equals("")) Pro[3]=photo.getProvince();
                    if(photo.getCity()!=null)
                        Cit[3] = photo.getCity();
                }
                //去过最东的城市
                if(ew>E){
                    E=ew;
                    if(photo.getImgUrl()!=null){
                        photo_url3=photo.getImgUrl();
                    }
                    if(!photo.getProvince().equals("")) Pro[0]=photo.getProvince();
                    if(photo.getCity()!=null) Cit[0]=photo.getCity();
                }
                //去过最西的城市
                if(ew<W){
                    W=ew;
                    if(photo.getImgUrl()!=null){
                        photo_url5=photo.getImgUrl();
                    }
                    if(!photo.getProvince().equals("")) Pro[2]=photo.getProvince();
                    if(photo.getCity()!=null) Cit[2]=photo.getCity();
                }
            }
            //最近一次拍摄的照片
            if(photo.getImgUrl()!=null) {
                if(photo.getPhotoTime()!=null){
                    if(time<photo.getPhotoTime())
                    {
                        time=photo.getPhotoTime();
                        photo_url2 = photo.getImgUrl();
                    }
                }
                else if(photo.getTime()!=null){
                    if(time<photo.getTime()){
                        time=photo.getTime();
                        photo_url2=photo.getImgUrl();
                    }
                }
            }
        }
        //去过的省份数量
        retString.add(vis_province.size()+"");
        //去过的城市数量
        retString.add(vis_city.size()+"");
        //满足时间条件的照片数
        retString.add(cnt+"");//2
        //去过最多的省
        retString.add(most_province);
        //去过最多的城市
        retString.add(most_city);
        retString.add(imgStringToList(photo_url1));// 5 最经常去的城市中其中一组照片
        retString.add(imgStringToList(photo_url2));// 6 最新一次的照片
        retString.add(imgStringToList(photo_url3));// 7 最东方的照片
        retString.add(imgStringToList(photo_url4));// 8 最南边的照片
        retString.add(imgStringToList(photo_url5));// 9 最西边的照片
        retString.add(imgStringToList(photo_url6));// 10 最北边的照片
        for(int i=0;i<4;i++){
            retString.add(Pro[i]);
        }
        for(int i=0;i<4;i++){
            retString.add(Cit[i]);
        }
        //去过的城市-19
        retString.add(cityList);
        //去过的省份-20
        retString.add(provinceList);
        //所有第足迹
        retString.add(photoList);
        return retString;
    }

    @Override
    public int getNum(int userId) {
        return photoMapper.getAllByUserId(userId).size();
    }

    @Override
    public Photo getPhotoById(int id) {
        Photo photo=photoMapper.getById(id);
        List<String> list = JSONObject.parseArray(photo.getImgUrl(), String.class);
        photo.setSTime(TimeUtils.timeChange(photo.getTime()));
        photo.setImgList(list);
        return photo;
    }

    @Override
    public void delete(int photoId,int userId) {
        photoMapper.delete(photoId, userId);
    }

    @Override
    public void save(Photo photo){

//        String url=photo.getImgUrl();
//        try {
//            String img=URLDecoder.decode(url, "UTF-8");
//
//            List<String> imgList=new ArrayList<>();
//            String[] imgs = img.split(",");
//            photo.setImgList(Arrays.asList(imgs));
//            photo.setAddress(URLDecoder.decode(photo.getAddress(), "UTF-8"));
//            photo.setContent(URLDecoder.decode(photo.getContent(), "UTF-8"));
//            photo.setTitle(URLDecoder.decode(photo.getTitle(), "UTF-8"));
//            photo.setCity(URLDecoder.decode(photo.getCity(), "UTF-8"));
//            photo.setProvince(URLDecoder.decode(photo.getProvince(), "UTF-8"));

            byte b=0;
            photo.setVisible(b);
            photo.setImgUrl(JSONObject.toJSONString(photo.getImgList()));


//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        photo.setTime(System.currentTimeMillis());
        photoMapper.save(photo);
    }

    @Override
    public List<Photo> getPhotoByCity(int userId, String cityName) {

        List<Photo> byCity = photoMapper.getByCity(userId, cityName);
        for (Photo photo : byCity) {
            photo.setImgList(imgStringToList(photo.getImgUrl()));
            Long time = photo.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ctime=simpleDateFormat.format(new Date(time));
            photo.setSTime(ctime);
        }
        return byCity;
    }

    /***
     * 获取所有去过的城市其中的一张照片
     * @param userId
     * @return
     */
    @Override
    public List<Photo> getVisitCity(int userId) {
        List<Photo> photos = photoMapper.getAllByUserId(userId);
        Map<String,Integer> map =new HashMap<>();
        List<Photo> result=new ArrayList<>();
        for (Photo photo : photos) {

            if(map.containsKey(photo.getCity()));
            else{
                List<String> list = JSONObject.parseArray(photo.getImgUrl(), String.class);
                photo.setImgList(list);
                map.put(photo.getCity(),1);
                result.add(photo);
            }
        }
        return result;
    }

    @Override
    public List<Photo> getPhotoByProvince(int userId, String province) {

        List<Photo> byProvince = photoMapper.getByProvince(userId, province);

        for (Photo photo : byProvince) {
            photo.setImgList(imgStringToList(photo.getImgUrl()));
            Long time = photo.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String ctime=simpleDateFormat.format(new Date(time));
            photo.setSTime(ctime);
        }
        return byProvince;
    }


}
