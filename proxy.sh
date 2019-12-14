#yarn set proxy
yarn config set proxy http://127.0.0.1:1087
yarn config set https-proxy http://127.0.0.1:1087

#yarn delete proxy
yarn config delete proxy
yarn config delete https-proxy

#yarn 更新依赖
#yarn upgrade-interactive --latest
#需要手动选择升级的依赖包，按空格键选择，a 键切换所有，i 键反选选择


#npm获取用户配置文件
npm config get userconfig

#npm全局配置文件
npm config get globalconfig



#npm set proxy
npm config set proxy http://127.0.0.1:1087
npm config set https-proxy http://127.0.0.1:1087

#npm delete proxy
npm config delete proxy
npm config delete https-proxy


#pod set proxy
#pod install 慢
git config --global http.proxy socks5://127.0.0.1:1086

#pod delete proxy
git config --global --unset http.proxy
