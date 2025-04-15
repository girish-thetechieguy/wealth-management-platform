// Create admin user with full privileges
db.createUser({
  user: "admin",
  pwd: "admin123",
  roles: [
    { role: "userAdminAnyDatabase", db: "admin" },
    { role: "readWriteAnyDatabase", db: "admin" },
    { role: "dbAdminAnyDatabase", db: "admin" },
    { role: "clusterAdmin", db: "admin" }
  ]
});

// Create application-specific user
db.getSiblingDB("my_app_db").createUser({
  user: "app_user",
  pwd: "app123",
  roles: [
    { role: "readWrite", db: "my_app_db" },
    { role: "dbAdmin", db: "my_app_db" }
  ]
});