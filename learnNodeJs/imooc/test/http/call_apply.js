var pet = {
    words: '...',
    speak: function(say){
        console.info(say+" "+this.words);
    }
};

pet.speak("speak");

var dog = {
  words: 'wang'
};

//call改变运行时上下文  speak的中的this指向的是pet  当使用call时  将pet中的this指向了dog
pet.speak.call(dog,'speak');

pet.speak.apply(dog,['speak']);

/** 上下文分为运行时上下文  定义时上下文 和 可改变的上下文(call 和 apply) */

/** call和apply的区别
 *  call('指向的对象',parameter1,parameter2,...)
 *  apply(指向的对象,[parameter1,parameter2,...])
 * */