/**
 * Created by ZH on 2016/5/6.
 */

var People = function(){
        this.name = '';
        this.age = 0;
        this.address = '';
};

People.prototype.getAddress = function(){
  return this.address;
};

People.prototype.setAddress = function(address){
    this.address = address;
};