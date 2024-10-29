import React from 'react';
import {  View,  Text,  TextInput,  ScrollView,  TouchableOpacity,  Image,  StyleSheet,} from 'react-native';
import Icon from 'react-native-vector-icons/MaterialIcons';

export default function ElectronicsScreen() {
  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Icon name="arrow-back" size={24} />
        <Text style={styles.headerTitle}>Electronics</Text>
        <Icon name="account-circle" size={36} />
      </View>

      <View style={styles.searchBar}>
        <TextInput style={styles.searchInput} placeholder="Search" />
        <Icon name="filter-list" size={24} />
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>Categories</Text>
        <TouchableOpacity>
          <Text style={styles.seeAll}>See all</Text>
        </TouchableOpacity>
      </View>
      <ScrollView
        horizontal
        showsHorizontalScrollIndicator={false}
        style={styles.categories}>
        <View style={styles.categoryItem}>
          <Icon name="phone-android" size={50} />
        </View>
        <View style={styles.categoryItem}>
          <Icon name="tablet" size={50} />
        </View>
        <View style={styles.categoryItem}>
          <Icon name="laptop" size={50} />
        </View>
      </ScrollView>

      <View style={styles.tabButtons}>
        <Text style={[styles.tabButton, styles.activeTab]}>Best Sales</Text>
        <Text style={styles.tabButton}>Best Matched</Text>
        <Text style={styles.tabButton}>Popular</Text>
      </View>

      <ScrollView style={styles.productList}>
        {products.map((product, index) => (
          <TouchableOpacity key={index} style={styles.productCard}>
            <Icon name="smartphone" size={50} style={styles.productIcon} />
            <View style={styles.productInfo}>
              <Text style={styles.productName}>{product.name}</Text>
              <View style={styles.ratingContainer}>
                <Icon name="star" size={16} color="#FFD700" />
                <Icon name="star" size={16} color="#FFD700" />
                <Icon name="star" size={16} color="#FFD700" />
                <Icon name="star" size={16} color="#FFD700" />
                <Icon name="star-border" size={16} color="#FFD700" />
              </View>
            </View>
            <Text style={styles.productPrice}>{product.price}</Text>
          </TouchableOpacity>
        ))}
      </ScrollView>
      <View style={styles.footer}>
        <Icon name="home" size={24} />
        <Icon name="search" size={24} />
        <Icon name="favorite" size={24} />
        <Icon name="message" size={24} />
        <Icon name="account-circle" size={24} />
      </View>
    </View>
  );
}

const products = [
  { name: 'Smartphone', price: '$899' },
  { name: 'Smartphone', price: '$899' },
  { name: 'Smartphone', price: '$789' },
  { name: 'Smartphone', price: '$999' },
];

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#fff' },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    padding: 16,
  },
  headerTitle: { fontSize: 18, fontWeight: 'bold' },
  searchBar: {
    flexDirection: 'row',
    alignItems: 'center',
    margin: 16,
    padding: 8,
    backgroundColor: '#f0f0f0',
    borderRadius: 8,
  },
  searchInput: { flex: 1, padding: 8 },
  section: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 16,
  },
  sectionTitle: { fontSize: 18, fontWeight: 'bold' },
  seeAll: { color: '#007BFF' },
  categories: { flexDirection: 'row', paddingLeft: 16 },
  categoryItem: {
    alignItems: 'center',
    justifyContent: 'center',
    width: 80,
    height: 80,
    backgroundColor: '#e0e0e0',
    marginRight: 16,
    borderRadius: 8,
  },
  tabButtons: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    padding: 16,
  },
  tabButton: { fontSize: 16 },
  activeTab: { fontWeight: 'bold', color: '#007BFF' },
  productList: { padding: 16 },
  productCard: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 16,
    backgroundColor: '#f9f9f9',
    marginBottom: 16,
    borderRadius: 8,
  },
  productIcon: { marginRight: 16 },
  productInfo: { flex: 1 },
  productName: { fontSize: 16, fontWeight: 'bold' },
  ratingContainer: { flexDirection: 'row', marginTop: 4 },
  productPrice: { fontSize: 18, fontWeight: 'bold', color: '#007BFF' },
  footer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    padding: 16,
    borderTopWidth: 1,
    borderColor: '#e0e0e0',
  },
});
