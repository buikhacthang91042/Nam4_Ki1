import React, { useState, useEffect } from "react";
import { useNavigation } from "@react-navigation/native";
import {
  StyleSheet,
  Text,
  View,
  Image,
  TouchableOpacity,
  TextInput,
  Alert,
  FlatList,
  ScrollView,
} from "react-native";
import Icon from "react-native-vector-icons/Ionicons";

export default function () {
  const [selectedChoice, setSelectedChoice] = useState("Best Sales");
  const [selectedCategory, setSelectedCategory] = useState("mobile");
  const [product, setProduct] = useState([]);
  const [bannerIMG, setBannerIMG] = useState([]);
  useEffect(() => {
    async function fetchProduct() {
      try {
        const response = await fetch(
          `https://64546532c18adbbdfeb551c3.mockapi.io/api/products?category=${selectedCategory}&type=${selectedChoice}`
        );

        const data = await response.json();
        console.log(data);

        setProduct(data.slice(0, 4));
      } catch (error) {
        console.error("Failed to fetch products:", error);
      }
    }
    fetchProduct();
  }, [selectedCategory, selectedChoice]);

  useEffect(() => {
    async function fetchBanner() {
      try {
        const response1 = await fetch(
          `https://64546532c18adbbdfeb551c3.mockapi.io/api/banner`
        );
        const data1 = await response1.json();
        setBannerIMG(data1);
        console.log(data1);
      } catch (error) {
        console.error("Không thể tải banner", error);
      }
    }
    fetchBanner();
  }, []);

  function handleChoicePress(choice) {
    setSelectedChoice(choice);
  }
  function handleCategoryPress(category) {
    setSelectedCategory(category);
  }

  const renderProduct = ({ item }) => (
    <View style={style.productItem}>
      <View style={style.detailIMG}>
        <Image source={{ uri: item.image }} style={style.productImage} />
      </View>
      <View style={style.detail}>
        <Text style={style.productName}>{item.name}</Text>
        <Text style={style.productPrice}>${item.price}</Text>
      </View>
    </View>
  );
  return (
    <View style={style.container}>
      <ScrollView contentContainerStyle={style.scrollContainer}>
        <View style={style.header}>
          <View
            style={{
              flex: 0.9,
              flexDirection: "row",
              alignItems: "center",
              backgroundColor: "lightgrey",
            }}
          >
            <Icon name="search" size={24}></Icon>
            <TextInput placeholder="Search" style={{ marginLeft: 10 }} />
          </View>
          <View
            style={{
              flex: 0.1,
              flexDirection: "row",
              justifyContent: "center",
              alignItems: "center",
              marginLeft: 40,
              backgroundColor: "lightgrey",
            }}
          >
            <TouchableOpacity>
              <Icon name="filter" size={20}></Icon>
            </TouchableOpacity>
          </View>
        </View>
        <View style={style.categories}>
          <Text style={{ fontSize: 20, fontWeight: "bold" }}>Categories</Text>
          <TouchableOpacity
            style={{ flex: 0.2, flexDirection: "row", alignItems: "center" }}
          >
            <Text style={{ opacity: 0.3 }}>See all</Text>
            <Icon name="chevron-forward"></Icon>
          </TouchableOpacity>
        </View>
        <View style={style.categories1}>
          <View style={style.categories_choice}>
            <TouchableOpacity onPress={() => handleCategoryPress("mobile")}>
              <Image
                source={require("../assets/image/ctg_mobile.png")}
                style={{ width: "100%", height: "100%", borderRadius: 12 }}
              />
            </TouchableOpacity>
          </View>
          <View style={style.categories_choice}>
            <TouchableOpacity onPress={() => handleCategoryPress("ipad")}>
              <Image
                source={require("../assets/image/ctg_ipad.png")}
                style={{ width: "100%", height: "100%", borderRadius: 12 }}
              />
            </TouchableOpacity>
          </View>
          <View style={style.categories_choice}>
            <TouchableOpacity onPress={() => handleCategoryPress("laptop")}>
              <Image
                source={require("../assets/image/ctg_Laptop.png")}
                style={{ width: "100%", height: "100%", borderRadius: 12 }}
              />
            </TouchableOpacity>
          </View>
        </View>
        <View style={style.choice}>
          {["Best Sales", "Best Matched", "Popular"].map((choice) => (
            <TouchableOpacity
              key={choice}
              style={[
                style.touchChoice,
                selectedChoice === choice && style.choiceActive,
              ]}
              onPress={() => handleChoicePress(choice)}
            >
              <Text
                style={[
                  style.textChoice,
                  selectedChoice === choice && style.textChoiceActive,
                ]}
              >
                {choice}
              </Text>
            </TouchableOpacity>
          ))}
        </View>
        <View style={style.product}>
          <FlatList
            data={product}
            renderItem={renderProduct}
            keyExtractor={(item) => item.id.toString()}
          />
        </View>
        <View style={{ justifyContent: "center", alignItems: "center" }}>
          <TouchableOpacity style={style.butonSeeAll}>
            <Text style={{ fontSize: 20, opacity: 0.5 }}>See all</Text>
          </TouchableOpacity>
        </View>
        <View style={style.banner}>
          <FlatList
            data={bannerIMG}
            renderItem={({ item }) => (
              <View
                style={{
                  marginHorizontal: 5,

                  alignItems: "center",
                  width: 402,
                  height: 200,
                }}
              >
                <Image
                  source={{ uri: item.imageBanner }}
                  style={{ width: "95%", height: 150, borderRadius: 10 }}
                  resizeMode="cover"
                />
              </View>
            )}
            showsHorizontalScrollIndicator={false}
            keyExtractor={(item) => item.id.toString()}
            pagingEnabled
            horizontal
          />
        </View>
      </ScrollView>
      <View style={style.footer}>
        <View style={style.viewFooter}>
          <TouchableOpacity style={style.footerV}>
            <Icon name="home" style={style.icon}></Icon>
            <Text>Home</Text>
          </TouchableOpacity>
        </View>
        <View style={style.viewFooter}>
          <TouchableOpacity style={style.footerV}>
            <Icon name="search" style={style.icon}></Icon>
            <Text>Search</Text>
          </TouchableOpacity>
        </View>
        <View style={style.viewFooter}>
          <TouchableOpacity style={style.footerV}>
            <Icon name="heart" style={style.icon}></Icon>
            <Text>Favorite</Text>
          </TouchableOpacity>
        </View>
        <View style={style.viewFooter}>
          <TouchableOpacity style={style.footerV}>
            <Icon name="chatbox-ellipses-outline" style={style.icon}></Icon>
            <Text>Inbox</Text>
          </TouchableOpacity>
        </View>
        <View style={style.viewFooter}>
          <TouchableOpacity style={style.footerV}>
            <Icon name="person-circle-outline" style={style.icon}></Icon>
            <Text>Account</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}
const style = StyleSheet.create({
  scrollContainer: {
    flexGrow: 1,
  },
  container: {
    flex: 1,
    backgroundColor: "white",
  },
  header: {
    flex: 1,
    flexDirection: "row",
    height: 50,
    justifyContent: "space-between",
  },
  categories: {
    flex: 0.7,

    justifyContent: "space-between",
    alignItems: "flex-start",
    flexDirection: "row",
    marginTop: 20,
  },
  categories1: {
    flex: 1,
    flexDirection: "row",
    paddingHorizontal: 0,
    marginTop: 15,
  },
  categories_choice: {
    flex: 0.5,
    borderRadius: 12,
    height: 120,
    marginHorizontal: 5,
  },
  choice: {
    flex: 1,
    flexDirection: "row",
    alignItems: "center",
    marginTop: 20,
    justifyContent: "space-around",
  },
  touchChoice: {
    alignItems: "center",
    justifyContent: "center",
    height: 30,
    width: 90,
  },
  textChoice: {
    opacity: 0.6,
  },
  choiceActive: {
    backgroundColor: "#CCFFFF",
  },
  textChoiceActive: {
    color: "#00CCFF",
  },
  product: {
    marginTop: 20,
    flex: 0,
    height: 450,
  },
  banner: {
    flex: 1,
    height: 150,

    marginTop: 25,
  },
  footer: {
    height: 60,
    backgroundColor: "lightgrey",
    flexDirection: "row",
    justifyContent: "space-around",
    borderRadius: 16,
  },
  productItem: {
    flex: 1,
    flexDirection: "row",
    padding: 8,
    borderWidth: 0.4,
    borderRadius: 15,
    width: "92.5%",
    marginTop: 10,
    marginLeft: 15,
  },
  productImage: { width: 80, height: 80, borderRadius: 10 },
  productName: { marginTop: 5, fontWeight: "bold", fontSize: 18 },
  productPrice: { color: "red", fontSize: 15 },
  detail: {
    flex: 0.7,
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
  },
  detailIMG: {
    flex: 0.29,
  },
  butonSeeAll: {
    flex: 0.5,
    backgroundColor: "lightgrey",
    height: 40,
    marginTop: 0,
    alignItems: "center",
    justifyContent: "center",
    borderRadius: 2,
    width: "93%",
  },
  footerV: {
    justifyContent: "center",
    alignItems: "center",
  },
  icon: {
    fontSize: 20,
  },
  viewFooter: {
    alignItems: "center",
    justifyContent: "center",
  },
});
