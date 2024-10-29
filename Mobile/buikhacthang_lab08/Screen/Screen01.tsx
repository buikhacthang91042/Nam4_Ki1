import React, { useState } from 'react';
import {
  View,
  Text,
  TextInput,
  TouchableOpacity,
  StyleSheet,
  Alert,
} from 'react-native';
import Icon from 'react-native-vector-icons/Ionicons';

export default function LoginScreen({ navigation }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    const validEmail = 'thang';
    const validPassword = '123456';

    if (email === validEmail && password === validPassword) {
      navigation.navigate('Screen02');
    } else {
      Alert.alert('Đăng nhập thất bại', 'Email hoặc mật khẩu không đúng!');
    }
  };

  return (
    <View style={styles.container}>
      <Icon name="arrow-back" size={24} color="black" style={styles.backIcon} />

      <Icon name="logo-react" size={64} color="#5DB1F5" style={styles.logo} />

      <Text style={styles.title}>Hello Again!</Text>
      <Text style={styles.subtitle}>Log into your account</Text>

      <View style={styles.inputContainer}>
        <Icon name="mail-outline" size={20} color="gray" style={styles.icon} />
        <TextInput
          style={styles.input}
          placeholder="Enter your email address"
          keyboardType="email-address"
          value={email}
          onChangeText={setEmail}
        />
      </View>

      <View style={styles.inputContainer}>
        <Icon
          name="lock-closed-outline"
          size={20}
          color="gray"
          style={styles.icon}
        />
        <TextInput
          style={styles.input}
          placeholder="Enter your password"
          secureTextEntry
          value={password}
          onChangeText={setPassword}
        />
      </View>

      <Text style={styles.forgotText}>Forgot password?</Text>

      <TouchableOpacity style={styles.button} onPress={handleLogin}>
        <Text style={styles.buttonText}>Continue</Text>
      </TouchableOpacity>

      <Text style={styles.orText}>or</Text>

      <View style={styles.socialIcons}>
        <Icon name="logo-google" size={32} color="#EA4335" />
        <Icon name="logo-facebook" size={32} color="#4267B2" />
        <Icon name="logo-apple" size={32} color="#000000" />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  backIcon: { 
    position: 'absolute', 
    top: 50, 
    left: 20
     },
  logo: {
     marginBottom: 20 
     },
  title: { fontSize: 28,
   fontWeight: 'bold', 
   color: '#333' 
   },
  subtitle: { fontSize: 16, color: '#777' },
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    borderWidth: 1,
    borderRadius: 10,
    padding: 10,
    marginVertical: 10,
    width: '100%',
  },
  icon: { marginRight: 10 },
  input: { flex: 1, fontSize: 16 },
  forgotText: { color: '#5DB1F5', alignSelf: 'flex-end', marginVertical: 10 },
  button: {
    backgroundColor: '#5DB1F5',
    padding: 15,
    borderRadius: 10,
    width: '100%',
    alignItems: 'center',
    marginVertical: 10,
  },
  buttonText: { color: '#fff', fontSize: 16 },
  orText: { color: '#777', marginVertical: 10 },
  socialIcons: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    width: '60%',
  },
});
